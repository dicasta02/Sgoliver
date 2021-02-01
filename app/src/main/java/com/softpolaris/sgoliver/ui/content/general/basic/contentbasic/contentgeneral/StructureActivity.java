package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.contentgeneral;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.ui.base.BaseActivity;
import com.softpolaris.sgoliver.utilities.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author dcastano
 * @version 1.0
 * @since 14, November, 2018
 */
public class StructureActivity extends BaseActivity {
    @BindView(R.id.webViewStructure)
    WebView webViewStructure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure);
        ButterKnife.bind(this);

        initUI();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initUI() {
        webViewStructure.getSettings().setJavaScriptEnabled(true);
        webViewStructure.loadUrl(Constants.STRUCTURE_URL);
    }
}
