package com.gorrotowi.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void goSecondActivity(View v) {
        EditText edtxName = (EditText) findViewById(R.id.edtxName);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(getString(R.string.parameter_name), edtxName.getText().toString());
        startActivity(intent);
    }

}
