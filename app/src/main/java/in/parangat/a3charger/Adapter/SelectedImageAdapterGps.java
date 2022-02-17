package in.parangat.a3charger.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import in.parangat.a3charger.R;

public class SelectedImageAdapterGps extends RecyclerView.Adapter<SelectedImageAdapterGps.ViewHolder> {
    private final static String FOLDER = Environment.getExternalStorageDirectory() + "/PDF";
    private final ArrayList<Uri> mImageUriList2;
    private Context mContext;
    //  private boolean isUriType = true;

    public SelectedImageAdapterGps(ArrayList<Uri> mImageUriList, Context mContext) {
        this.mImageUriList2 = mImageUriList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, null);
        return new ViewHolder(view);
    }
/*

    public void setImageType(boolean isUriType) {
        this.isUriType = isUriType;
    }
*/

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        try {
            if (mImageUriList2.get(position).toString().contains("png") || mImageUriList2.get(position).toString().contains("jpg") || mImageUriList2.get(position).toString().contains("jpeg")) {
                Glide.with(mContext).load(mImageUriList2.get(position).toString()).into(holder.row_image);
            } else {
                Glide.with(mContext).load(R.drawable.a3_logo).into(holder.row_image);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ERROR", "" + e.getMessage());

        }
        holder.row_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageUriList2.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUriList2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView row_image,row_close;

        public ViewHolder(View itemView) {
            super(itemView);
            row_close = itemView.findViewById(R.id.report_image_row_close);
            row_image = itemView.findViewById(R.id.report_image_row_image);
        }
    }

    public static void loadGalleryImageFromUrl(Context context, String url, ImageView imageView) {
        if (url == null)
            url = "";
        Glide.with(context)
                .setDefaultRequestOptions(galleryOption)
                .load(Uri.parse(url))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.e("TAG", "Load failed", e);
                        // You can also log the individual causes:
                        for (Throwable t : e.getRootCauses()) {
                            Log.e("TAG", "Caused by", t);
                        }
                        // Or, to log all root causes locally, you can use the built in helper method:
                        e.logRootCauses("TAG");
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageView);
    }

    private static RequestOptions galleryOption = new RequestOptions()
            .placeholder(R.drawable.a3_logo)
            .error(R.drawable.a3_logo);
}
