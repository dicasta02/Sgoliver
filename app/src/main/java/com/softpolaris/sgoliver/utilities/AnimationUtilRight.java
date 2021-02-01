package com.softpolaris.sgoliver.utilities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import com.softpolaris.sgoliver.ui.slide.slideFragments.SlideOneView;
import com.softpolaris.sgoliver.ui.slide.slideFragments.SlideTwoView;

/**
 * @author dacastano
 * @version 1.0
 * @since 25, October, 2018
 */
public class AnimationUtilRight {

    public static void animate(View view, boolean a, SlideOneView slideOneView) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "translationX", a? -600 : 600, 0);
        objectAnimator.setDuration(500);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                slideOneView.showViewGone();
            }
        });
        animatorSet.play(objectAnimator);
        animatorSet.start();
    }
}
