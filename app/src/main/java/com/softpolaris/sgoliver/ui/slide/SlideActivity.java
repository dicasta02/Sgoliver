package com.softpolaris.sgoliver.ui.slide;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.ui.adapter.SlideAdapter;
import com.softpolaris.sgoliver.ui.base.BaseActivity;
import com.softpolaris.sgoliver.utilities.FontHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnPageChange;
import me.relex.circleindicator.CircleIndicator;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class SlideActivity extends BaseActivity implements SlideView {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.containerDots)
    CircleIndicator containerDots;
    @BindView(R.id.txtSkip)
    TextView txtSkip;
    @BindView(R.id.txtFinish)
    TextView txtFinish;
    @BindView(R.id.imbNext)
    ImageButton imbNext;

    @Inject
    SlidePresenter slidePresenter;

    @Inject
    FontHelper fontHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_slide);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        initUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        slidePresenter.detachView();
    }

    @Override
    public void loadContent(SlideAdapter slideAdapter) {
        viewPager.setAdapter(slideAdapter);
        containerDots.setViewPager(viewPager);
    }

    @Override
    public void changeSkipVisibility(boolean isVisible) {
        if (isVisible){
            if (txtSkip.getVisibility() != View.VISIBLE){
                txtSkip.setVisibility(View.VISIBLE);
            }
        }else {
            if (txtSkip.getVisibility() == View.VISIBLE){
                txtSkip.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void changeNextVisibility(boolean isVisible) {
        if (isVisible){
            if (imbNext.getVisibility() !=View.VISIBLE){
                imbNext.setVisibility(View.VISIBLE);
            }
        }else {
            if (imbNext.getVisibility() == View.VISIBLE){
                imbNext.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void changeFinishVisibility(boolean isVisible) {
        if (isVisible){
            if (txtFinish.getVisibility()!=View.VISIBLE){
                txtFinish.setVisibility(View.VISIBLE);
            }
        }else{
            if (txtFinish.getVisibility()==View.VISIBLE){
                txtFinish.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void callNextActivity(Class nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
        finishActivity();
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @OnPageChange(R.id.viewPager)
    public void pageChange(){
        slidePresenter.onPageChanged(viewPager);

    }

    @OnClick(R.id.txtSkip)
    public void onClickSkip(){
        slidePresenter.finishSlide();
    }

    @OnClick(R.id.imbNext)
    public void onClickNext(){
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        slidePresenter.onPageChanged(viewPager);
    }
    @OnClick(R.id.txtFinish)
    public void onClickFinish(){
        slidePresenter.finishSlide();
    }

    private void initUI() {
        slidePresenter.attachView(this);
        fontHelper.applyBoldFont(findViewById(R.id.globalConstraint));
        slidePresenter.content();
    }
}