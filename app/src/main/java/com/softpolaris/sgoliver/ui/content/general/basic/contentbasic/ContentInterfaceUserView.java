package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic;

import com.softpolaris.sgoliver.ui.adapter.MenuContentAdapter;
import com.softpolaris.sgoliver.ui.base.BaseView;

/**
 * @author dcastano
 * @version 1.0
 * @since 21, January, 2019
 */
public interface ContentInterfaceUserView extends BaseView {
    void nexActivity(Class nextActivity);

    void loadAdapter(MenuContentAdapter menuContentAdapter);
}
