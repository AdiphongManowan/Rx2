package com.example.adiphong.rx2;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Window;

public class LoadingViewDialog {

    private Activity activityContext;

    private Dialog loadingDialog;

    public LoadingViewDialog(Activity activityContext) {
        this.activityContext = activityContext;
    }

    public void showLoading() {
        loadingDialog = new Dialog(activityContext);

        loadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadingDialog.setContentView(R.layout.custom_loading_view);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        loadingDialog.show();
    }

    public void dismissLoading() {

        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    public void dismissLoading(DialogInterface.OnDismissListener dismissListener) {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            if (dismissListener != null) {
                loadingDialog.setOnDismissListener(dismissListener);
            }

            loadingDialog.dismiss();
        }
    }
}
