package com.softpolaris.sgoliver.ui.splash;

import android.os.SystemClock;

import com.softpolaris.sgoliver.ui.base.BasePresenter;
import com.softpolaris.sgoliver.utilities.Constants;
import com.softpolaris.sgoliver.utilities.PreferenceManager;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class SplashPresenter extends BasePresenter<SplashView> {
    private final long SPLASH_DELAY = TimeUnit.SECONDS.toMillis(3);

    @Inject
    PreferenceManager preferenceManager;

    @Inject
    SplashPresenter() {

    }

    @Override
    public void attachView(SplashView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    void setDestiny() {
        SystemClock.sleep(SPLASH_DELAY);

        if (preferenceManager.loadBool(Constants.KEY_SEEN, false)) {
            getView().showMenu();
        } else {
            getView().showSlide();
        }
    }
}