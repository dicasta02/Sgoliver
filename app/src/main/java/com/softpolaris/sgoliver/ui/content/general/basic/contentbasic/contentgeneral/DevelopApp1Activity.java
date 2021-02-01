package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.contentgeneral;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.utilities.Constants;

import static android.support.test.InstrumentationRegistry.getContext;

/**
 * @author dcastano
 * @version 1.0
 * @since 14, November, 2018
 */
public class DevelopApp1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_develop_app1);

        initUI();
    }

    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    private void initUI() {
        EditText edtUser = findViewById(R.id.edtUser);
        Button btnAccept = findViewById(R.id.btnAccept);

        btnAccept.setOnClickListener(v -> {
                    if (edtUser.getText().toString().equals("")) {
                        snackBarMsg(v);
                    } else {
                        Intent intent = new Intent(DevelopApp1Activity.this, DevelopApp2Activity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString(Constants.KEY_USER, edtUser.getText().toString().trim());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }

        );

        TextView txtMarquee = findViewById(R.id.txtMarquee);
        txtMarquee.setSelected(true);

    }

    private void snackBarMsg(View view) {
        Snackbar.make(view, getString(R.string.contentEmpty), Snackbar.LENGTH_LONG).show();
    }
}
