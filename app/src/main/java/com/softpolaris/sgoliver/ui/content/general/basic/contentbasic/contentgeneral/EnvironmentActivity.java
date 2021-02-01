package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.contentgeneral;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
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
public class EnvironmentActivity extends BaseActivity {
    @BindView(R.id.webViewEnviroment)
    WebView webViewEnvironment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);
        ButterKnife.bind(this);

        initUI();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initUI() {
        webViewEnvironment.getSettings().setJavaScriptEnabled(true);
        webViewEnvironment.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewEnvironment.getSettings().setSupportMultipleWindows(true);
        webViewEnvironment.setWebChromeClient(new WebChromeClient());
        webViewEnvironment.loadUrl(Constants.ENVIRONMENT_URL);
    }
}
