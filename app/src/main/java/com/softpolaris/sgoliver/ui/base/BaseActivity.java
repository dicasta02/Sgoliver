package com.softpolaris.sgoliver.ui.base;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.softpolaris.sgoliver.CustomApp;
import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.di.component.ActivityComponent;
import com.softpolaris.sgoliver.di.component.ApplicationComponent;
import com.softpolaris.sgoliver.di.module.ActivityModule;
import com.softpolaris.sgoliver.heplers.DialogsManager;
import com.softpolaris.sgoliver.utilities.Constants;
import com.softpolaris.sgoliver.utilities.LogManager;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class BaseActivity extends AppCompatActivity implements BaseView {
    private ActivityComponent activityComponent;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ApplicationComponent applicationComponent = ((CustomApp) getApplication()).getApplicationComponent();
        this.activityComponent = applicationComponent.addActivityComponent(new ActivityModule(this));

        progressDialog = new ProgressDialog(this, R.style.AlertDialog_Theme);
        progressDialog.setCancelable(false);
    }

    @Override
    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public void showDialog(String title, String msg) {
        showDialog(DialogsManager.newInstance(DialogsManager.INFORMATION, title, msg));
    }

    @Override
    public void showDialog(String title, String msg, String positiveTitle, DialogInterface.OnClickListener positiveButton) {
        DialogsManager dialogsManager = DialogsManager.newInstance(DialogsManager.INFORMATION_1_BUTTON,
                title, msg);
        dialogsManager.setAcceptListener(positiveTitle, positiveButton);
        showDialog(dialogsManager);
    }

    @Override
    public void showDialogNoInternet() {
        showDialog(DialogsManager.newInstance(DialogsManager.INFORMATION, getString(R.string.appName),
                getString(R.string.allNoInternet)));
    }

    @Override
    public void showCustomProgress(String msg) {
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    @Override
    public void hideCustomProgress() {
        try {
            if (!this.isFinishing()) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            new LogManager(BaseActivity.class).printError(e);
        }
    }

    private void showDialog(DialogsManager dialogsManager) {
        dismissDialog();

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().add(dialogsManager, Constants.DIALOG).commitAllowingStateLoss();
    }

    private void dismissDialog() {
        try {
            if (getFragmentManager() != null) {
                getFragmentManager().executePendingTransactions();
                Fragment prev = getFragmentManager().findFragmentByTag(Constants.DIALOG);

                if (prev != null) {
                    DialogsManager df = (DialogsManager) prev;
                    df.dismissAllowingStateLoss();
                }
            }
        } catch (Exception e) {
            Log.e(Constants.TAG, "Error in dismiss dialog -> " + e.getMessage());
        }
    }
}