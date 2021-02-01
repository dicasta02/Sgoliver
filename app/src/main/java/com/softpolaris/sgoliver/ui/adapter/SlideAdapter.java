package com.softpolaris.sgoliver.ui.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author dacastano
 * @version 1.0
 * @since 23, October, 2018
 */
public class SlideAdapter extends FragmentPagerAdapter {
    private List<Fragment> content;

    public SlideAdapter(FragmentManager fragmentManager, List<Fragment> content) {
        super(fragmentManager);
        this.content = content;
    }

    @Override
    public Fragment getItem(int i) {
        return content.get(i);
    }

    @Override
    public int getCount() {
        return content != null ? content.size() : 0;
    }
}
