package com.softpolaris.sgoliver.ui.content.general.basic.contentbasic.contentgeneral;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.utilities.Constants;

/**
 * @author dcastano
 * @version 1.0
 * @since 14, November, 2018
 */
public class DevelopApp2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developmen_app2);

        initUI();
    }

    private void initUI() {
        TextView txtHello = findViewById(R.id.txtUser);
        Bundle bundle = this.getIntent().getExtras();
        assert bundle != null;
        txtHello.setText(bundle.getString(Constants.KEY_USER));
    }
}
