package com.softpolaris.sgoliver.ui.slide.slideFragments;

import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.view.View;

import com.softpolaris.sgoliver.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class SlideOnePresenter extends BasePresenter<SlideOneView> {
    @Inject
    public SlideOnePresenter(){

    }

    @Override
    public void attachView(SlideOneView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void initAnimationView(View... views) {
        float velocity = 30000;
        float maxValue = 50;
        float starValue = -50;
        for (View v : views) {
            SpringAnimation springAnim = new SpringAnimation(v, DynamicAnimation.TRANSLATION_X, 0);
            springAnim.setStartValue(starValue);
            springAnim.setMaxValue(maxValue);
            springAnim.setStartVelocity(velocity);
            springAnim.start();
        }
    }
}
