package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.menus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.ui.base.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MenusActivity extends BaseActivity {
    @BindView(R.id.globalConstraint)
    ConstraintLayout globalConstraint;
    @BindView(R.id.webView)
    WebView webView;

    private static final String SITE_KEY = "6Leo84AUAAAAABsimov0S9k085Jr20q4vWXFchCZ";
    private static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
    private static final String DOMAIN_RECAPTCHA = "https://poc-td1-recaptchav3.appspot.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        ButterKnife.bind(this);

        initUI();

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "response");
        webView.loadDataWithBaseURL(DOMAIN_RECAPTCHA,
                "<html>" +
                        "<head>" +
                        "<script src=\"https://www.google.com/recaptcha/api.js?render=6Leo84AUAAAAADoXSR7_ySJ5Gx8_VNi9a3CgB_tR\"></script>" +
                        "<script>function showToast2(token){" +
                        "var tokenResponse ;" + "grecaptcha.ready(function() {" +
                        "            grecaptcha.execute(\"6Leo84AUAAAAADoXSR7_ySJ5Gx8_VNi9a3CgB_tR\", {action: \"home\"})" +
                        "            .then(function(token) {" +
                        "                  tokenResponse = token;" +
                        "window.response.showToast(token);" +
                        "console.log('Token is: ' + tokenResponse)" +
                        "                                   });" +
                        "                           });" +
                        "}</script>" +
                        "</head>" +
                        "<body>" +
                        "<br>" +
                        "<div style=\"color:blue;text-align:center\">" +
                        "    <b>Prueba Recaptcha</b>" +
                        "</div>" +
                        "<div style=\"color:blue;text-align:center\">" +
                        "    <button onclick=\"showToast2()\">Enviar</button>" +
                        "</div>" +
                        "</body>" +
                        "</html>", "text/html", "utf-8", null);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                view.loadUrl("javascript:alert(sendToken()");
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }
        });

    }

    private void requestScore(String token) {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("secret", SITE_KEY)
                .addFormDataPart("response", token)
                .build();

        Request request = new Request.Builder()
                .url(SITE_VERIFY_URL)
                .post(requestBody)
                .build();

        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                final String[] score = {""};

                runOnUiThread(() -> {
                    try {
                        JSONObject json = new JSONObject(response.body().string());
                        score[0] = json.getString("score");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Snackbar snackbar = Snackbar
                            .make(globalConstraint, "You score is: " + score[0], Snackbar.LENGTH_LONG);
                    View snackBarView = snackbar.getView();
                    snackBarView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    snackbar.show();
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getApplicationContext(), "onFailure", Toast.LENGTH_LONG).show();
            }
        });
    }

    class WebAppInterface {
        public Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void showToast(String userResponseToken) {
            requestScore(userResponseToken);
        }

    }
}
