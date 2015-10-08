package com.gorrotowi.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View v) {
        startService(new Intent(this, MiServicio.class));
    }

    public void stopService(View v) {
        stopService(new Intent(this, MiServicio.class));
    }

}
