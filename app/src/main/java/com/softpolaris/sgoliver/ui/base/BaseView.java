package com.softpolaris.sgoliver.ui.base;

import android.content.DialogInterface;

import com.softpolaris.sgoliver.di.component.ActivityComponent;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public interface BaseView {
    ActivityComponent getActivityComponent();

    void showDialog(String title, String msg);

    void showDialog(String title, String msg, String positiveTitle, DialogInterface.OnClickListener positiveButton);

    void showDialogNoInternet();

    void showCustomProgress(String msg);

    void hideCustomProgress();
}