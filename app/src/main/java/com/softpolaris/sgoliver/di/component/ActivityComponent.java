package com.softpolaris.sgoliver.di.component;

import com.softpolaris.sgoliver.di.module.ActivityModule;
import com.softpolaris.sgoliver.ui.content.general.GeneralContentActivity;
import com.softpolaris.sgoliver.ui.content.general.basic.BasicActivity;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.ContentGeneralActivity;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.ContentInterfaceUserActivity;
import com.softpolaris.sgoliver.ui.slide.SlideActivity;
import com.softpolaris.sgoliver.ui.slide.slideFragments.SlideOneFragment;
import com.softpolaris.sgoliver.ui.slide.slideFragments.SlideTwoFragment;
import com.softpolaris.sgoliver.ui.slide.slideFragments.SlideTwoPresenter;
import com.softpolaris.sgoliver.ui.splash.SplashActivity;

import dagger.Subcomponent;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    ///////////////////////////////////////////////////////////////////////////
    // Activities
    ///////////////////////////////////////////////////////////////////////////
    void inject(SplashActivity splashActivity);
    void inject(SlideActivity slideActivity);
    void inject(GeneralContentActivity generalContentActivity);
    void inject(BasicActivity basicActivity);
    void inject(ContentGeneralActivity contentGeneralActivity);
    void inject(ContentInterfaceUserActivity contentInterfaceUserActivity);
    ///////////////////////////////////////////////////////////////////////////
    // Fragments
    ///////////////////////////////////////////////////////////////////////////
    void inject(SlideOneFragment slideOneFragment);
    void inject(SlideTwoFragment slideTwoFragment);
}