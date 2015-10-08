package com.gorrotowi.userform;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    TextView txtName, txtMail, txtTwitter, txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Bundle params = getIntent().getExtras();

        txtName = (TextView) findViewById(R.id.txtName);
        txtMail = (TextView) findViewById(R.id.txtMail);
        txtTwitter = (TextView) findViewById(R.id.txtTwitter);
        txtDate = (TextView) findViewById(R.id.txtDate);

        txtName.setText(params.getString(getString(R.string.name), ""));
        txtMail.setText(params.getString(getString(R.string.mail), ""));
        txtTwitter.setText(params.getString(getString(R.string.twitter), ""));
        txtDate.setText(params.getString(getString(R.string.date), ""));

    }

    public void sendMail(View v) {

        String message = getString(R.string.name) + " " + txtName.getText().toString() + "\n"
                + getString(R.string.mail) + " " + txtMail.getText().toString() + "\n"
                + getString(R.string.twitter) + " " + txtTwitter.getText().toString() + "\n"
                + getString(R.string.date_string) + " " + txtDate.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(emailIntent);

    }

}
