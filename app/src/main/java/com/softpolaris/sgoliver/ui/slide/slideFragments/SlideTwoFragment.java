package com.softpolaris.sgoliver.ui.slide.slideFragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.ui.base.BaseFragment;
import com.softpolaris.sgoliver.utilities.AnimationUtilLeft;
import com.softpolaris.sgoliver.utilities.Constants;
import com.softpolaris.sgoliver.utilities.FontHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author dacastano
 * @version 1.0
 * @since 29, October, 2018
 */
public class SlideTwoFragment extends BaseFragment implements SlideTwoView {
    @BindView(R.id.imgLogo)
    ImageView imgLogo;
    @BindView(R.id.txtDescription)
    TextView txtDescription;
    @BindView(R.id.txtxDescriptionTwo)
    TextView txtDescriptionTwo;
    @BindView(R.id.txtWebSite)
    TextView txtWebSite;

    @Inject
    SlideTwoPresenter slideTwoPresenter;

    @Inject
    FontHelper fontHelper;

    public static SlideTwoFragment newInstance() {

        return new SlideTwoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide_two, container, false);
        getActivityComponent().inject(this);
        ButterKnife.bind(this, view);

        initUI(view);

        return view;
    }

    @OnClick(R.id.txtWebSite)
    public void onClickWebSite() {
        showWebSite();
    }

    @Override
    public void showViewEnter() {
        txtDescription.setVisibility(View.VISIBLE);
        txtDescriptionTwo.setVisibility(View.VISIBLE);
        txtWebSite.setVisibility(View.VISIBLE);

        slideTwoPresenter.initAnimationView(txtDescription, txtDescriptionTwo, txtWebSite);
    }


    private void initUI(View view) {
        slideTwoPresenter.attachView(this);
        fontHelper.applyBoldFont(view.findViewById(R.id.globalConstraint));

        AnimationUtilLeft.animate(txtDescription,true, this);
        AnimationUtilLeft.animate(txtDescriptionTwo,true, this);
        AnimationUtilLeft.animate(txtWebSite,true, this);
    }

    public void showWebSite() {
        Uri uri = Uri.parse(Constants.COSTUMER_SERVICE_URL);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
