package com.gorrotowi.userform;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendData(View view) {
        EditText edxtName = (EditText) findViewById(R.id.edtxName);
        EditText edxtMail = (EditText) findViewById(R.id.edtxMail);
        EditText edxtTwitter = (EditText) findViewById(R.id.edtxTwitter);
        DatePicker datePicker = (DatePicker) findViewById(R.id.dtPicker);

        String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();

        Intent intent = new Intent(this, UserInfoActivity.class);
        intent.putExtra(getString(R.string.name), edxtName.getText().toString());
        intent.putExtra(getString(R.string.mail), edxtMail.getText().toString());
        intent.putExtra(getString(R.string.twitter), edxtTwitter.getText().toString());
        intent.putExtra(getString(R.string.date), date);

        startActivity(intent);

    }

}
