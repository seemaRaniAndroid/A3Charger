package in.parangat.a3charger.UI.Activities.Detail;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import droidninja.filepicker.models.sort.SortingTypes;
import in.parangat.a3charger.Adapter.SelectedImageAdapterGps;
import in.parangat.a3charger.Adapter.SelectedImageAdapterVector;
import in.parangat.a3charger.Adapter.SelectedImageAdapterLocation;
import in.parangat.a3charger.Base.BaseActivity;
import in.parangat.a3charger.Helper.Validations;
import in.parangat.a3charger.R;
import in.parangat.a3charger.fontclass.SemiBoldTextView;
import in.parangat.a3charger.model.ReceeResponse;
import in.parangat.a3charger.network.ApiClient;
import in.parangat.a3charger.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends BaseActivity implements View.OnClickListener {

    private static final int CUSTOM_REQUEST_CODE1 = 531;
    private static final int CUSTOM_REQUEST_CODE2 = 532;
    private static final int CUSTOM_REQUEST_CODE3 = 533;
    private final int CAMERA_REQUEST_CODE = 101;
    private final int GALLERY_REQUEST_CODE = 102;

    private ArrayList<Uri> mImageUriList = new ArrayList<>();
    private ArrayList<Uri> mImageUriList2 = new ArrayList<>();
    private ArrayList<Uri> mImageUriList3 = new ArrayList<>();
    private int MAX_ATTACHMENT_COUNT = 5;
    private ArrayList<String> docPaths = new ArrayList<>();
    private ArrayList<String> photoPaths = new ArrayList<>();
    private ArrayList<String> photoPaths2 = new ArrayList<>();
    private ArrayList<String> photoPaths3 = new ArrayList<>();
    private Uri imgUri;
    private RecyclerView rv_location_preview, rv_gps_preview, rv_vector_location_preview;
    private Spinner spin_select_slot, spin_suitable_location;
    private SelectedImageAdapterLocation mImageAdapter;
    private SelectedImageAdapterGps selectedImageAdapterGps;
    private SelectedImageAdapterVector selectedImageAdapterVector;
    private String selected_slot, suitable_location;
    private EditText edt_no_of_outlet, edt_address, edt_contact_person, edt_daily_footfall, edt_no_of_employee, edt_nearest_distance, edt_date, edt_remarks;
    private String venue_id;
    final Calendar myCalendar = Calendar.getInstance();
    private SemiBoldTextView header_title;

    public static String getPath(Context context, Uri uri) throws URISyntaxException {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = {"_data"};
            Cursor cursor = null;

            try {
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
                Log.e("exc", e.getMessage());

            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        init();
    }

    @Override
    public void init() {
        venue_id = getIntent().getExtras().getString("venue_id");
        //   Toast.makeText(DetailsActivity.this, venue_id, Toast.LENGTH_SHORT).show();

        findAllId();
        setListener();
        setRecyclerViewLocation();
        setRecyclerViewGps();
        setRecyclerViewVector();

        final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.select_slot));
        spin_select_slot.setAdapter(arrayAdapter1);


        spin_select_slot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected_slot = adapterView.getItemAtPosition(i).toString();
                //  Toast.makeText(adapterView.getContext(), selected_slot, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.suitable_location));
        spin_suitable_location.setAdapter(arrayAdapter2);

        spin_suitable_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                suitable_location = adapterView.getItemAtPosition(i).toString();
                //  Toast.makeText(adapterView.getContext(), suitable_location, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }
        };
        edt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(DetailsActivity.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        header_title.setText("Recce");
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        edt_date.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void findAllId() {
        rv_location_preview = findViewById(R.id.rv_location_preview);
        rv_gps_preview = findViewById(R.id.rv_gps_preview);
        rv_vector_location_preview = findViewById(R.id.rv_vector_location_preview);
        spin_select_slot = findViewById(R.id.spin_select_slot);
        spin_suitable_location = findViewById(R.id.spin_suitable_location);

        edt_no_of_outlet = findViewById(R.id.edt_no_of_outlet);
        edt_address = findViewById(R.id.edt_address);
        edt_contact_person = findViewById(R.id.edt_contact_person);
        edt_daily_footfall = findViewById(R.id.edt_daily_footfall);
        edt_no_of_employee = findViewById(R.id.edt_no_of_employee);
        edt_nearest_distance = findViewById(R.id.edt_nearest_distance);
        edt_date = findViewById(R.id.edt_date);
        edt_remarks = findViewById(R.id.edt_remarks);
        header_title = findViewById(R.id.header_title);

    }

    private void setListener() {
        findViewById(R.id.btn_location_photo).setOnClickListener(this);
        findViewById(R.id.btn_gps_photo).setOnClickListener(this);
        findViewById(R.id.btn_vector_photo).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);
        findViewById(R.id.header_back).setOnClickListener(this);
    }


    @Override
    public void initControl() {

    }

    private void setRecyclerViewLocation() {
        rv_location_preview.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_location_preview.setLayoutManager(layoutManager);
        mImageAdapter = new SelectedImageAdapterLocation(mImageUriList, this);
        rv_location_preview.setAdapter(mImageAdapter);
    }

    private void setRecyclerViewGps() {
        rv_gps_preview.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_gps_preview.setLayoutManager(layoutManager);
        selectedImageAdapterGps = new SelectedImageAdapterGps(mImageUriList2, this);
        rv_gps_preview.setAdapter(selectedImageAdapterGps);
    }

    private void setRecyclerViewVector() {
        rv_vector_location_preview.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_vector_location_preview.setLayoutManager(layoutManager);
        selectedImageAdapterVector = new SelectedImageAdapterVector(mImageUriList3, this);
        rv_vector_location_preview.setAdapter(selectedImageAdapterVector);
    }

    private void openImagePickerDialog(int flag, ArrayList<String> photoPaths) {
        int maxCount = MAX_ATTACHMENT_COUNT - docPaths.size();
        if ((docPaths.size() + photoPaths.size()) == MAX_ATTACHMENT_COUNT) {
            Toast.makeText(DetailsActivity.this, "Cannot select more than " + MAX_ATTACHMENT_COUNT + " items",
                    Toast.LENGTH_SHORT).show();
        } else {
            FilePickerBuilder.getInstance()
                    .setMaxCount(maxCount)
                    .setSelectedFiles(photoPaths)
                    .setActivityTitle("Please select media")
                    .enableVideoPicker(false)
                    .enableCameraSupport(true)
                    .showGifs(true)
                    .showFolderView(true)
                    .enableSelectAll(false)
                    .enableImagePicker(true)
                    .withOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .pickPhoto(DetailsActivity.this, flag);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CUSTOM_REQUEST_CODE1 && resultCode == RESULT_OK && data != null) {
            photoPaths = new ArrayList<>();
            photoPaths.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA));
            for (int i = 0; i < photoPaths.size(); i++) {
                mImageUriList.add(Uri.parse(photoPaths.get(i)));
            }
            mImageAdapter.notifyDataSetChanged();

        }
        if (requestCode == CUSTOM_REQUEST_CODE2 && resultCode == RESULT_OK && data != null) {
            photoPaths2 = new ArrayList<>();
            photoPaths2.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA));
            for (int i = 0; i < photoPaths2.size(); i++) {
                mImageUriList2.add(Uri.parse(photoPaths2.get(i)));
            }
            selectedImageAdapterGps.notifyDataSetChanged();

        }
        if (requestCode == CUSTOM_REQUEST_CODE3 && resultCode == RESULT_OK && data != null) {
            photoPaths3 = new ArrayList<>();
            photoPaths3.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA));
            for (int i = 0; i < photoPaths3.size(); i++) {
                mImageUriList3.add(Uri.parse(photoPaths3.get(i)));
            }
            selectedImageAdapterVector.notifyDataSetChanged();

        }

        if (requestCode == FilePickerConst.REQUEST_CODE_DOC && resultCode == RESULT_OK && data != null) {
            docPaths = new ArrayList<>();
            docPaths.addAll(data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_DOCS));
            for (int i = 0; i < docPaths.size(); i++) {
                mImageUriList.add(Uri.parse(docPaths.get(i)));
            }
            mImageAdapter.notifyDataSetChanged();
            for (int i = 0; i < docPaths.size(); i++) {
                mImageUriList2.add(Uri.parse(docPaths.get(i)));
            }
            selectedImageAdapterGps.notifyDataSetChanged();
            for (int i = 0; i < docPaths.size(); i++) {
                mImageUriList3.add(Uri.parse(docPaths.get(i)));
            }
            selectedImageAdapterVector.notifyDataSetChanged();
        }
        if (requestCode == CAMERA_REQUEST_CODE && RESULT_OK == resultCode) {
            try {
                Bitmap photo = MediaStore.Images.Media.getBitmap(
                        getContentResolver(), imgUri);
                Log.i("photo size", "" + photo.getByteCount());
                mImageUriList.add(imgUri);
                mImageAdapter.notifyDataSetChanged();


                mImageUriList2.add(imgUri);
                selectedImageAdapterGps.notifyDataSetChanged();


                mImageUriList3.add(imgUri);
                selectedImageAdapterVector.notifyDataSetChanged();

                Log.i("photo size", "" + photo.getByteCount());

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (requestCode == GALLERY_REQUEST_CODE && RESULT_OK == resultCode) {
            //mutltiple image is selected using long click listener

            Uri uri = data.getData();
            String path = null;
            try {
                path = getPath(this, uri);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            Log.e("path", path);
            mImageUriList.add(Uri.parse(path));
            mImageAdapter.notifyDataSetChanged();

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_location_photo:
                if (mImageUriList.size() < 5) {
                    openImagePickerDialog(CUSTOM_REQUEST_CODE1, photoPaths);
                } else {
                    // Snackbar.make(mMainView, R.string.upload_pic_limit_msg, Snackbar.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_gps_photo:
                if (mImageUriList2.size() < 5) {
                    openImagePickerDialog(CUSTOM_REQUEST_CODE2, photoPaths2);
                } else {

                }
                break;
            case R.id.btn_vector_photo:
                if (mImageUriList3.size() < 5) {
                    openImagePickerDialog(CUSTOM_REQUEST_CODE3, photoPaths3);
                } else {

                }
                break;

            case R.id.header_back:
                onBackPressed();
                break;

            case R.id.btn_next:
                if (!Validations.hasText(edt_no_of_outlet))
                    edt_no_of_outlet.setError(getResources().getString(R.string.error_empty));
                else if (!Validations.hasText(edt_address))
                    edt_address.setError(getResources().getString(R.string.error_empty));
                else if (!Validations.hasText(edt_contact_person))
                    edt_contact_person.setError(getResources().getString(R.string.error_empty));
                else if (!Validations.hasText(edt_daily_footfall.getText().toString()))
                    edt_daily_footfall.setError(getResources().getString(R.string.error_empty));
                else if (!Validations.hasText(edt_no_of_employee.getText().toString()))
                    edt_no_of_employee.setError(getResources().getString(R.string.error_empty));
                else if (!Validations.hasText(edt_nearest_distance.getText().toString()))
                    edt_nearest_distance.setError(getResources().getString(R.string.error_empty));
                else if (!Validations.hasText(edt_date.getText().toString()))
                    edt_date.setError(getResources().getString(R.string.error_empty));
                else if (!Validations.hasText(edt_remarks.getText().toString()))
                    edt_remarks.setError(getResources().getString(R.string.error_empty));

                else {

                    Intent intent = new Intent(DetailsActivity.this, ReviewDetailActivity.class);
                    intent.putExtra("noOfOutlet", edt_no_of_outlet.getText().toString());
                    intent.putExtra("address", edt_address.getText().toString());
                    intent.putExtra("contactPerson", edt_contact_person.getText().toString());
                    intent.putExtra("dailyFootfall", edt_daily_footfall.getText().toString());
                    intent.putExtra("noOfEmployee", edt_no_of_employee.getText().toString());
                    intent.putExtra("nearestDistance", edt_nearest_distance.getText().toString());
                    intent.putExtra("date", edt_date.getText().toString());
                    intent.putExtra("remarks", edt_remarks.getText().toString());
                    intent.putExtra("noOfSlots", selected_slot);
                    intent.putExtra("suitableLocation", suitable_location);
                    intent.putExtra("venue_id", venue_id);

                    intent.putParcelableArrayListExtra("images_location", mImageUriList);
                    intent.putParcelableArrayListExtra("images_gps", mImageUriList2);
                    intent.putParcelableArrayListExtra("images_vector", mImageUriList3);

                    startActivity(intent);


                }

}
    }


}
