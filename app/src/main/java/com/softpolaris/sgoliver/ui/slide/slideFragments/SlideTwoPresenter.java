package com.softpolaris.sgoliver.ui.slide.slideFragments;

import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.view.View;

import com.softpolaris.sgoliver.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * @author dacastano
 * @version 1.0
 * @since 29, October, 2018
 */
public class SlideTwoPresenter extends BasePresenter<SlideTwoView> {
    @Inject
    public SlideTwoPresenter() {

    }

    @Override
    public void attachView(SlideTwoView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void initAnimationView(View... views) {
        float velocity = 10000;
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
