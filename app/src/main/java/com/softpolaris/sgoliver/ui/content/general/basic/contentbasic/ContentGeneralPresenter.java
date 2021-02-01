package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.di.scope.ActivityContext;
import com.softpolaris.sgoliver.models.MenuItem;
import com.softpolaris.sgoliver.ui.adapter.MenuContentAdapter;
import com.softpolaris.sgoliver.ui.base.BasePresenter;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.contentgeneral.ComponentActivity;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.contentgeneral.DevelopApp1Activity;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.contentgeneral.EnvironmentActivity;
import com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.contentgeneral.StructureActivity;
import com.softpolaris.sgoliver.utilities.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author dcastano
 * @version 1.0
 * @since 14, November, 2018
 */
public class ContentGeneralPresenter extends BasePresenter<ContentGeneralView> {
    @Inject
    @ActivityContext
    Context context;

    @Inject
    public ContentGeneralPresenter() {

    }

    @Override
    public void attachView(ContentGeneralView view) {
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
            case Constants.ENVIRONMENT:
                getView().nexActivity(EnvironmentActivity.class);
                break;
            case Constants.STRUCTURE:
                getView().nexActivity(StructureActivity.class);
                break;
            case Constants.COMPONENTS:
                getView().nexActivity(ComponentActivity.class);
                break;
            case Constants.DEVELOPMENT_APP:
                getView().nexActivity(DevelopApp1Activity.class);
                break;
        }
    }

    private List<MenuItem> getData() {
        List<MenuItem> menuItems = new ArrayList<>();

        @SuppressLint("Recycle")
        TypedArray icons = context.getResources().obtainTypedArray(R.array.menuGeneralConceptIcons);
        String[] textName = context.getResources().getStringArray(R.array.menuGeneralConceptList);

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
