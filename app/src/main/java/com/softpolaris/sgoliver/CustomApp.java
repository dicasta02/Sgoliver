package com.softpolaris.sgoliver;

import android.app.Application;

import com.softpolaris.sgoliver.di.component.ApplicationComponent;
import com.softpolaris.sgoliver.di.component.DaggerApplicationComponent;
import com.softpolaris.sgoliver.di.module.ApplicationModule;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class CustomApp extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this)).build();
        }
        return applicationComponent;
    }
}
