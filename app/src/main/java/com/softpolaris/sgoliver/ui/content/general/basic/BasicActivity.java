package com.softpolaris.sgoliver.ui.content.general.basic;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.heplers.RecyclerDividerDecoration;
import com.softpolaris.sgoliver.models.MenuItem;
import com.softpolaris.sgoliver.ui.adapter.GeneralAdapterView;
import com.softpolaris.sgoliver.ui.adapter.MenuContentAdapter;
import com.softpolaris.sgoliver.ui.base.BaseActivity;
import com.softpolaris.sgoliver.utilities.FontHelper;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class BasicActivity extends BaseActivity implements BasicView, GeneralAdapterView<MenuItem> {
    @BindView(R.id.globalConstraint)
    ConstraintLayout globalConstraint;
    @BindView(R.id.recyclerViewBasic)
    RecyclerView recyclerViewBasic;

    @Inject
    BasicPresenter basicPresenter;

    @Inject
    FontHelper fontHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_actiivity);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        initUI();
    }

    @Override
    public void onItemSelected(MenuItem itemSelected) {
        basicPresenter.handleOption(itemSelected);
    }

    @Override
    public void nexActivity(Class nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
    }

    @Override
    public void loadAdapter(MenuContentAdapter menuContentAdapter) {
        Context context = recyclerViewBasic.getContext();
        LayoutAnimationController controller;
        controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_right);
        menuContentAdapter.setAdapterView(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewBasic.setLayoutManager(layoutManager);
        recyclerViewBasic.setHasFixedSize(true);
        recyclerViewBasic.setLayoutAnimation(controller);
        recyclerViewBasic.addItemDecoration(new RecyclerDividerDecoration(this, RecyclerDividerDecoration.VERTICAL_LIST));
        recyclerViewBasic.setAdapter(menuContentAdapter);
    }

    private void initUI() {
        basicPresenter.attachView(this);
        basicPresenter.loadContent();

        fontHelper.applyFont(globalConstraint);
    }
}
