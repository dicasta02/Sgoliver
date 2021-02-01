package com.softpolaris.sgoliver.ui.slide;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.view.ViewPager;

import com.softpolaris.sgoliver.ui.adapter.SlideAdapter;
import com.softpolaris.sgoliver.ui.base.BasePresenter;
import com.softpolaris.sgoliver.ui.content.general.GeneralContentActivity;
import com.softpolaris.sgoliver.ui.slide.slideFragments.SlideOneFragment;
import com.softpolaris.sgoliver.ui.slide.slideFragments.SlideTwoFragment;
import com.softpolaris.sgoliver.utilities.Constants;
import com.softpolaris.sgoliver.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class SlidePresenter extends BasePresenter<SlideView> {
    @Inject
    Activity activity;

    @Inject
    PreferenceManager preferenceManager;

    @Inject
    public SlidePresenter() {

    }

    @Override
    public void attachView(SlideView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void onPageChanged(ViewPager viewPager) {
        boolean isLast = viewPager.getCurrentItem() == viewPager.getAdapter().getCount() - 1;
        if (!isLast) {
            getView().changeSkipVisibility(true);
            getView().changeNextVisibility(true);
            getView().changeFinishVisibility(false);
        } else {
            getView().changeSkipVisibility(false);
            getView().changeNextVisibility(false);
            getView().changeFinishVisibility(true);
        }
    }

    public void content(){
        prepareContent();
    }

    public void finishSlide() {
        if (preferenceManager.loadBool(Constants.KEY_SEEN, false)) {
            getView().finishActivity();
        } else {
            getView().callNextActivity(GeneralContentActivity.class);
        }
    }

    private void loadContent(List<Fragment> content) {
        if (content == null) {
            content = new ArrayList<>(0);
        }

        SlideAdapter slideAdapter = new SlideAdapter(activity.getFragmentManager(),content);
        getView().loadContent(slideAdapter);
    }

    private void prepareContent(){
        List<Fragment> content = new ArrayList<>();
        content.add(SlideOneFragment.newInstance());
        content.add(SlideTwoFragment.newInstance());
        loadContent(content);
    }

}
