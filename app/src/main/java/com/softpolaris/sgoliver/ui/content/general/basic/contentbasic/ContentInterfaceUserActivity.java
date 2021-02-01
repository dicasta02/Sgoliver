package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic;

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

public class ContentInterfaceUserActivity extends BaseActivity implements ContentInterfaceUserView, GeneralAdapterView<MenuItem> {
    @BindView(R.id.globalConstraint)
    ConstraintLayout globalConstraint;
    @BindView(R.id.recyclerViewUserInterface)
    RecyclerView recyclerViewUserInterface;

    @Inject
    ContentInterfaceUserPresenter contentInterfaceUserPresenter;

    @Inject
    FontHelper fontHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_interface_user);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        initUI();
    }

    @Override
    public void onItemSelected(MenuItem itemSelected) {
        contentInterfaceUserPresenter.handleOption(itemSelected);
    }

    @Override
    public void nexActivity(Class nextActivity) {
        Intent intent = new Intent(this,nextActivity);
        startActivity(intent);
    }

    @Override
    public void loadAdapter(MenuContentAdapter menuContentAdapter) {
        Context context = recyclerViewUserInterface.getContext();
        LayoutAnimationController controller;
        controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_right);
        menuContentAdapter.setAdapterView(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewUserInterface.setLayoutManager(layoutManager);
        recyclerViewUserInterface.setHasFixedSize(true);
        recyclerViewUserInterface.setLayoutAnimation(controller);
        recyclerViewUserInterface.addItemDecoration(new RecyclerDividerDecoration(this, RecyclerDividerDecoration.VERTICAL_LIST));
        recyclerViewUserInterface.setAdapter(menuContentAdapter);
    }

    private void initUI() {
        contentInterfaceUserPresenter.attachView(this);
        contentInterfaceUserPresenter.loadContent();

        fontHelper.applyFont(globalConstraint);
    }
}
