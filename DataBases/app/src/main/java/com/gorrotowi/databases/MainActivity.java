package com.gorrotowi.databases;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveData(View v) {
        AccionesDB dataBase = new AccionesDB(this, "agenda", null, 1);

        SQLiteDatabase acciones = dataBase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", ((EditText) findViewById(R.id.edtxName)).getText().toString());
        values.put("telefono", ((EditText) findViewById(R.id.edtxPhone)).getText().toString());
        values.put("correo", ((EditText) findViewById(R.id.edtxMail)).getText().toString());
        values.put("twitter", ((EditText) findViewById(R.id.edtxTwitter)).getText().toString());
        acciones.insert("persona", null, values);
        acciones.close();
        ((EditText) findViewById(R.id.edtxName)).setText(null);
        ((EditText) findViewById(R.id.edtxPhone)).setText(null);
        ((EditText) findViewById(R.id.edtxMail)).setText(null);
        ((EditText) findViewById(R.id.edtxTwitter)).setText(null);
        Toast.makeText(this, R.string.success_message, Toast.LENGTH_SHORT).show();
    }

    public void showData(View v) {

        AccionesDB database = new AccionesDB(this, "agenda", null, 1);
        SQLiteDatabase acciones = database.getReadableDatabase();
        TextView txtResult = (TextView) findViewById(R.id.txtRegistersContent);
        txtResult.setText(null);
        Cursor registros = acciones.rawQuery("SELECT * FROM persona", null);

        while (registros.moveToNext()) {
            String detalle = getString(R.string.name_hint) + " " + registros.getString(1) + "\n"
                    + getString(R.string.hint_phone) + " " + registros.getString(2) + "\n"
                    + getString(R.string.hint_mail) + " " + registros.getString(3) + "\n"
                    + getString(R.string.hint_twitter) + " " + registros.getString(4) + "\n\n";
            txtResult.append(detalle);
        }
        registros.close();
        acciones.close();
    }

}
