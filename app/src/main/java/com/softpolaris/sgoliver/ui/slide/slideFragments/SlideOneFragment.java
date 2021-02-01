package com.softpolaris.sgoliver.ui.slide.slideFragments;

import android.annotation.SuppressLint;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.ui.base.BaseFragment;
import com.softpolaris.sgoliver.utilities.AnimationUtilRight;
import com.softpolaris.sgoliver.utilities.FontHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class SlideOneFragment extends BaseFragment implements SlideOneView {
    @BindView(R.id.txtWelcome)
    TextView txtWelcome;
    @BindView(R.id.txtDescription)
    TextView txtDescription;

    @Inject
    SlideOnePresenter slideOnePresenter;

    @Inject
    FontHelper fontHelper;

    public static SlideOneFragment newInstance(){

        return new SlideOneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide_one, container, false);
        getActivityComponent().inject(this);
        ButterKnife.bind(this, view);

        initUI(view);

        return view;
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void showViewGone() {
        txtWelcome.setVisibility(View.VISIBLE);
        txtDescription.setVisibility(View.VISIBLE);

        slideOnePresenter.initAnimationView(txtWelcome, txtDescription);
    }

    private void initUI(View view) {
        slideOnePresenter.attachView(this);
        fontHelper.applyBoldFont(view.findViewById(R.id.globalConstraint));

        AnimationUtilRight.animate(txtWelcome,true, this);
        AnimationUtilRight.animate(txtDescription,true, this);
    }
}
