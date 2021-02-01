package com.softpolaris.sgoliver.ui.content.general;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.di.scope.ActivityContext;
import com.softpolaris.sgoliver.models.MenuItem;
import com.softpolaris.sgoliver.ui.adapter.MenuContentAdapter;
import com.softpolaris.sgoliver.ui.base.BaseActivity;
import com.softpolaris.sgoliver.ui.base.BasePresenter;
import com.softpolaris.sgoliver.ui.content.general.basic.BasicActivity;
import com.softpolaris.sgoliver.ui.content.general.firebase.FireBaseActivity;
import com.softpolaris.sgoliver.ui.content.general.googleplay.GooglePlayActivity;
import com.softpolaris.sgoliver.utilities.Constants;
import com.softpolaris.sgoliver.utilities.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author dacastano
 * @version 1.0
 * @since 23, October, 2018
 */
public class GeneralContentPresenter extends BasePresenter<GeneralContentView> {
    @Inject
    @ActivityContext
    Context context;

    @Inject
    public GeneralContentPresenter() {

    }

    @Override
    public void attachView(GeneralContentView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadContent() {
        MenuContentAdapter menuContentAdapter = new MenuContentAdapter(getData());
        getView().loadAdapter(menuContentAdapter);
    }

    public void handleOption(MenuItem optionSelected) {
        switch (optionSelected.getIndex()) {
            case Constants.BASIC:
                getView().nexActivity(BasicActivity.class);
                break;
            case Constants.GOOGLE:
                getView().nexActivity(GooglePlayActivity.class);
                break;
            case Constants.FIRE_BASE:
                getView().nexActivity(FireBaseActivity.class);
                break;
        }
    }

    private List<MenuItem> getData() {
        List<MenuItem> menuItems = new ArrayList<>();

        @SuppressLint("Recycle")
        TypedArray icons = context.getResources().obtainTypedArray(R.array.menuBasicIcons);
        String[] textName = context.getResources().getStringArray(R.array.menuBasicList);

        for (int i = 0; i < textName.length; i++) {
            MenuItem item = new MenuItem();
            item.setIndex((byte) i);
            item.setImgIcon(icons.getResourceId(i, -1));
            item.setTxtName(textName[i]);
            menuItems.add(item);
        }

        icons.recycle();

        return menuItems;
    }
}
