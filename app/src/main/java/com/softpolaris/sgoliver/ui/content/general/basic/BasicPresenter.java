package com.softpolaris.sgoliver.ui.content.general.basic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.di.scope.ActivityContext;
import com.softpolaris.sgoliver.models.MenuItem;
import com.softpolaris.sgoliver.ui.adapter.MenuContentAdapter;
import com.softpolaris.sgoliver.ui.base.BasePresenter;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.ContentGeneralActivity;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.ContentInterfaceUserActivity;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.menus.MenusActivity;
import com.softpolaris.sgoliver.utilities.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author dacastano
 * @version 1.0
 * @since 23, October, 2018
 */
public class BasicPresenter extends BasePresenter<BasicView> {
    @Inject
    @ActivityContext
    Context context;

    @Inject
    public BasicPresenter() {

    }

    @Override
    public void attachView(BasicView view) {
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
            case Constants.CONCEPT_GENERAL:
                getView().nexActivity(ContentGeneralActivity.class);
                break;
            case Constants.INTERFACE:
                getView().nexActivity(ContentInterfaceUserActivity.class);
                break;
            case Constants.MENU:
                getView().nexActivity(MenusActivity.class);
                break;
            case Constants.WIDGETS:

                break;
            case Constants.PREFERENCES:

                break;
            case Constants.BD:

                break;
            case Constants.FILES:

                break;
            case Constants.XML_:

                break;
            case Constants.CONTENT:

                break;
            case Constants.NOTIFICATION:

                break;
            case Constants.SERVICES:

                break;
            case Constants.TASK:

                break;
            case Constants.DEBUG:

                break;
        }
    }

    private List<MenuItem> getData() {
        List<MenuItem> menuItems = new ArrayList<>();

        @SuppressLint("Recycle")
        TypedArray icons = context.getResources().obtainTypedArray(R.array.menuContentBasicIcons);
        String[] textName = context.getResources().getStringArray(R.array.menuContentBasicList);

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
