package com.softpolaris.sgoliver.di.module;

import android.app.Activity;
import android.content.Context;

import com.softpolaris.sgoliver.di.scope.ActivityContext;
import com.softpolaris.sgoliver.di.scope.ApplicationContext;
import com.softpolaris.sgoliver.utilities.FontHelper;

import dagger.Module;
import dagger.Provides;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    FontHelper provideFont() {
        return new FontHelper(activity);
    }
}