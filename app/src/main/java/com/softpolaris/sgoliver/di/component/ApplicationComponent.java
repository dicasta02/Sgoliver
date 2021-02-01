package com.softpolaris.sgoliver.di.component;

import android.app.Application;
import android.content.Context;

import com.softpolaris.sgoliver.di.module.ActivityModule;
import com.softpolaris.sgoliver.di.module.ApplicationModule;
import com.softpolaris.sgoliver.di.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    @ApplicationContext
    Context context();

    Application application();

    ActivityComponent addActivityComponent(ActivityModule activityModule);
}