package com.softpolaris.sgoliver.di.module;

import android.app.Application;
import android.content.Context;

import com.softpolaris.sgoliver.di.scope.ApplicationContext;
import com.softpolaris.sgoliver.utilities.PreferenceManager;

import dagger.Module;
import dagger.Provides;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    PreferenceManager preferenceManager() {
        return new PreferenceManager(application.getBaseContext());
    }
}