package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.di.scope.ActivityContext;
import com.softpolaris.sgoliver.models.MenuItem;
import com.softpolaris.sgoliver.ui.adapter.MenuContentAdapter;
import com.softpolaris.sgoliver.ui.base.BasePresenter;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.userInterface.BasicControlsActivity;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.userInterface.UserInterface;
import com.softpolaris.sgoliver.utilities.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author dcastano
 * @version 1.0
 * @since 21, January, 2019
 */
public class ContentInterfaceUserPresenter extends BasePresenter<ContentInterfaceUserView> {
    @Inject
    @ActivityContext
    Context context;

    @Inject
    public ContentInterfaceUserPresenter() {

    }

    @Override
    public void attachView(ContentInterfaceUserView view) {
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
            case Constants.INTERFACE_LAYOUTS:
                getView().nexActivity(UserInterface.class);
                break;
            case Constants.BUTTONS:
                getView().nexActivity(BasicControlsActivity.class);
                break;
            case Constants.TEXT:

                break;
            case Constants.CHECKBOX:

                break;
            case Constants.SPINNER:

                break;
            case Constants.LIST:

                break;
            case Constants.VIEWHOLDER:

                break;
            case Constants.GRIDVIEW:

                break;
            case Constants.RECYCLERVIEW:

                break;
            case Constants.CARDVIEW:

                break;
            case Constants.CONTROLS1:

                break;
            case Constants.CONTROLS2:

                break;
            case Constants.CONTROLS3:

                break;
            case Constants.TABS:

                break;
            case Constants.FRAGMENTS:

                break;
            case Constants.BASIC_ACTIONBAR:

                break;
            case Constants.TOOLBAR:

                break;
            case Constants.FILTER_TABS:

                break;
            case Constants.NAVIGATION_DRAWER:

                break;
            case Constants.NAVIGATION_VIEW:

                break;
            case Constants.COORDINATIONLAYOUT:

                break;
            case Constants.PALETTE:

                break;
        }
    }

    private List<MenuItem> getData() {
        List<MenuItem> menuItems = new ArrayList<>();

        @SuppressLint("Recycle")
        TypedArray icons = context.getResources().obtainTypedArray(R.array.menuUserInterfaceIcons);
        String[] textName = context.getResources().getStringArray(R.array.menuUserInterfaceList);

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
