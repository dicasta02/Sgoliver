package com.softpolaris.sgoliver.ui.content.general;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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
public class GeneralContentActivity extends BaseActivity implements GeneralContentView, GeneralAdapterView<MenuItem> {
    @BindView(R.id.globalConstraint)
    ConstraintLayout globalConstraint;
    @BindView(R.id.reciclerViewGeneral)
    RecyclerView recyclerViewGeneral;

    @Inject
    GeneralContentPresenter generalContentPresenter;

    @Inject
    FontHelper fontHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_content);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        initUI();
    }

    @Override
    public void onItemSelected(MenuItem itemSelected) {
        generalContentPresenter.handleOption(itemSelected);
    }

    @Override
    public void nexActivity(Class nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
    }

    @Override
    public void loadAdapter(MenuContentAdapter menuContentAdapter) {
        Context context = recyclerViewGeneral.getContext();
        LayoutAnimationController controller;
        controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_right);
        menuContentAdapter.setAdapterView(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewGeneral.setLayoutManager(layoutManager);
        recyclerViewGeneral.setHasFixedSize(true);
        recyclerViewGeneral.setLayoutAnimation(controller);
        recyclerViewGeneral.addItemDecoration(new RecyclerDividerDecoration(this, RecyclerDividerDecoration.VERTICAL_LIST));
        recyclerViewGeneral.setAdapter(menuContentAdapter);
    }

    private void initUI() {
        generalContentPresenter.attachView(this);
        generalContentPresenter.loadContent();

        fontHelper.applyFont(globalConstraint);
    }
}
