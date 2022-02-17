package in.parangat.a3charger.Helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import in.parangat.a3charger.R;

public class Utils {
    private static Dialog dialog, message_dialog;

    public static void showLoadingDialog(Context context) {
        if (!((Activity) context).isDestroyed() && !((Activity) context).isFinishing()) {
            dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(R.layout.layout_progress_dialog, null);
            dialog.setContentView(v);
            dialog.setCancelable(false);
            dialog.show();
        }
    }

    public static void hideLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

}
