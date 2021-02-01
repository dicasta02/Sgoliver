package com.softpolaris.sgoliver.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.softpolaris.sgoliver.ui.base.BaseActivity;
import com.softpolaris.sgoliver.ui.content.general.GeneralContentActivity;
import com.softpolaris.sgoliver.ui.slide.SlideActivity;

import javax.inject.Inject;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class SplashActivity extends BaseActivity implements SplashView {
    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);

        initUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.detachView();
    }

    @Override
    public void showSlide() {
        callActivity(SlideActivity.class);
    }

    @Override
    public void showMenu() {
        callActivity(GeneralContentActivity.class);
    }

    private void initUI() {
        splashPresenter.attachView(this);
        splashPresenter.setDestiny();
    }

    private void callActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        finish();
    }
}