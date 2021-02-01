package com.softpolaris.sgoliver.ui.slide;

import com.softpolaris.sgoliver.ui.adapter.SlideAdapter;
import com.softpolaris.sgoliver.ui.base.BaseView;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public interface SlideView extends BaseView {
    void loadContent(SlideAdapter slideAdapter);

    void changeSkipVisibility(boolean isVisible);

    void changeNextVisibility(boolean isVisible);

    void changeFinishVisibility(boolean isVisible);

    void callNextActivity(Class nextActivity);

    void finishActivity();

}