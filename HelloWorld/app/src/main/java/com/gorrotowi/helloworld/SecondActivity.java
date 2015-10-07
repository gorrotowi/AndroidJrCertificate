package com.gorrotowi.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView txtYourName = (TextView) findViewById(R.id.txtContentSecondActivity);

        Bundle params = getIntent().getExtras();
        String name = params.getString(getString(R.string.parameter_name, ""));

        txtYourName.append(name);
    }
}
