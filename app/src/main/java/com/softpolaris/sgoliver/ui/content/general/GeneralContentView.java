package com.softpolaris.sgoliver.ui.content.general;

import com.softpolaris.sgoliver.ui.adapter.MenuContentAdapter;
import com.softpolaris.sgoliver.ui.base.BaseView;

/**
 * @author dacastano
 * @version 1.0
 * @since 23, October, 2018
 */
public interface GeneralContentView extends BaseView {
    void nexActivity(Class nextActivity);

    void loadAdapter(MenuContentAdapter menuContentAdapter);
}
