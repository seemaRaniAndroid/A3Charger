package in.parangat.a3charger.UI.Activities.Detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;
import java.util.ArrayList;

import in.parangat.a3charger.Adapter.SelectedImageAdapterGps;
import in.parangat.a3charger.Adapter.SelectedImageAdapterLocation;
import in.parangat.a3charger.Adapter.SelectedImageAdapterVector;
import in.parangat.a3charger.Base.BaseActivity;
import in.parangat.a3charger.Helper.Utils;
import in.parangat.a3charger.Helper.Validations;
import in.parangat.a3charger.R;
import in.parangat.a3charger.UI.Activities.SubmittedSuccessfully;
import in.parangat.a3charger.fontclass.SemiBoldTextView;
import in.parangat.a3charger.model.ReceeResponse;
import in.parangat.a3charger.network.ApiClient;
import in.parangat.a3charger.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewDetailActivity extends BaseActivity implements View.OnClickListener {

    private EditText edt_no_of_outlet, edt_address, edt_contact_person, edt_daily_footfall, edt_no_of_employee, edt_no_slots,
            edt_nearest_distance, edt_suitable_location, edt_date, edt_remarks;
    private String noOfOutlet, address, contactPerson, dailyFootfall, noOfEmployee, nearestDistance, date,
            noOfSlots, suitableLocation, remarks, venue_id;
    private ImageView header_edit, header_back;
    private ArrayList<Uri> listlocation;
    private ArrayList<Uri> listgps;
    private ArrayList<Uri> listvector;
    private Button btn_next;
    private RecyclerView rv_location_photo, rv_gps_photo, rv_nearest_vector_location;
    private SelectedImageAdapterLocation mImageAdapter;
    private SelectedImageAdapterGps selectedImageAdapterGps;
    private SelectedImageAdapterVector selectedImageAdapterVector;
    private SemiBoldTextView header_title, lable_1, lable_2, lable_3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);
        init();
    }

    @Override
    public void init() {

        edt_no_of_outlet = findViewById(R.id.edt_no_of_outlet);
        edt_address = findViewById(R.id.edt_address);
        edt_contact_person = findViewById(R.id.edt_contact_person);
        edt_daily_footfall = findViewById(R.id.edt_daily_footfall);
        edt_no_of_employee = findViewById(R.id.edt_no_of_employee);
        edt_no_slots = findViewById(R.id.edt_no_slots);
        edt_nearest_distance = findViewById(R.id.edt_nearest_distance);
        edt_suitable_location = findViewById(R.id.edt_suitable_location);
        edt_date = findViewById(R.id.edt_date);
        edt_remarks = findViewById(R.id.edt_remarks);
        header_edit = findViewById(R.id.header_edit);
        header_back = findViewById(R.id.header_back);
        btn_next = findViewById(R.id.btn_next);
        rv_location_photo = findViewById(R.id.rv_location_photo);
        rv_gps_photo = findViewById(R.id.rv_gps_photo);
        rv_nearest_vector_location = findViewById(R.id.rv_nearest_vector_location);
        header_title = findViewById(R.id.header_title);
        lable_1 = findViewById(R.id.lable_1);
        lable_2 = findViewById(R.id.lable_2);
        lable_3 = findViewById(R.id.lable_3);


        header_edit.setOnClickListener(this);
        header_back.setOnClickListener(this);
        btn_next.setOnClickListener(this);


        Intent i = getIntent();
        noOfOutlet = i.getStringExtra("noOfOutlet");
        address = i.getStringExtra("address");
        contactPerson = i.getStringExtra("contactPerson");
        dailyFootfall = i.getStringExtra("dailyFootfall");
        noOfEmployee = i.getStringExtra("noOfEmployee");
        nearestDistance = i.getStringExtra("nearestDistance");
        date = i.getStringExtra("date");
        noOfSlots = i.getStringExtra("noOfSlots");
        suitableLocation = i.getStringExtra("suitableLocation");
        remarks = i.getStringExtra("remarks");
        venue_id = i.getStringExtra("venue_id");


        listlocation = i.getParcelableArrayListExtra("images_location");
        listgps = i.getParcelableArrayListExtra("images_gps");
        listvector = i.getParcelableArrayListExtra("images_vector");


        edt_no_of_outlet.setText(noOfOutlet);
        edt_address.setText(address);
        edt_contact_person.setText(contactPerson);
        edt_daily_footfall.setText(dailyFootfall);
        edt_no_of_employee.setText(noOfEmployee);
        edt_no_slots.setText(noOfSlots);
        edt_nearest_distance.setText(nearestDistance);
        edt_suitable_location.setText(suitableLocation);
        edt_date.setText(date);
        edt_remarks.setText(remarks);


        header_title.setText("Recce");

        if (listlocation.isEmpty()) {
            lable_1.setVisibility(View.GONE);

        } else {
            rv_location_photo.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            rv_location_photo.setLayoutManager(layoutManager);
            mImageAdapter = new SelectedImageAdapterLocation(listlocation, this);
            rv_location_photo.setAdapter(mImageAdapter);

        }


        if (listgps.isEmpty()) {
            lable_2.setVisibility(View.GONE);

        } else {
            rv_gps_photo.setHasFixedSize(true);
            LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
            layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
            rv_gps_photo.setLayoutManager(layoutManager2);
            selectedImageAdapterGps = new SelectedImageAdapterGps(listgps, this);
            rv_gps_photo.setAdapter(selectedImageAdapterGps);
        }


        if (listvector.isEmpty()) {
            lable_3.setVisibility(View.GONE);

        } else {
            rv_nearest_vector_location.setHasFixedSize(true);
            LinearLayoutManager layoutManager3 = new LinearLayoutManager(this);
            layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
            rv_nearest_vector_location.setLayoutManager(layoutManager3);
            selectedImageAdapterVector = new SelectedImageAdapterVector(listvector, this);
            rv_nearest_vector_location.setAdapter(selectedImageAdapterVector);
        }

    }

    @Override
    public void initControl() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.header_back:
                onBackPressed();
                break;
            case R.id.header_edit:
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
                    //send data to server
                    getRecceData();
                }
        }
    }

    private void getRecceData() {
        Utils.showLoadingDialog(this);
        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<ReceeResponse> driverStatsResponseCall = service.getReceeData(venue_id,
                noOfOutlet, address, contactPerson, dailyFootfall,
                noOfEmployee, noOfSlots, nearestDistance, suitableLocation, date, remarks);
        driverStatsResponseCall.enqueue(new Callback<ReceeResponse>() {
            @Override
            public void onResponse(Call<ReceeResponse> call, Response<ReceeResponse> response) {
                Utils.hideLoadingDialog();
                if (response.isSuccessful()) {
                    if (response.isSuccessful()) {
                        Toast.makeText(ReviewDetailActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ReviewDetailActivity.this, SubmittedSuccessfully.class);
                        startActivity(intent);
                        finish();
                    }
                }

            }

            @Override
            public void onFailure(Call<ReceeResponse> call, Throwable t) {
                Utils.hideLoadingDialog();
                Toast.makeText(ReviewDetailActivity.this, "network_error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
