package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic;

import com.softpolaris.sgoliver.ui.adapter.MenuContentAdapter;
import com.softpolaris.sgoliver.ui.content.general.basic.BasicView;

/**
 * @author dcastano
 * @version 1.0
 * @since 14, November, 2018
 */
public interface ContentGeneralView extends BasicView {
    void nexActivity(Class nextActivity);

    void loadAdapter(MenuContentAdapter menuContentAdapter);
}
