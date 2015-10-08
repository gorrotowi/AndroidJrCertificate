package com.gorrotowi.contentproviders;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtLlamadas = (TextView) findViewById(R.id.txtLogContent);
        txtLlamadas.setText(null);

        Uri uriLlamadas = Uri.parse(getString(R.string.content_provider_calls));

        String[] campos = new String[]{
                CallLog.Calls.NUMBER,
                CallLog.Calls.DATE,
                CallLog.Calls.TYPE,
                CallLog.Calls.DURATION,
                CallLog.Calls.CACHED_NAME
        };

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(uriLlamadas, campos, null, null, CallLog.Calls.DATE + " DESC");
        while (cursor.moveToNext()) {
            int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
            int date = cursor.getColumnIndex(CallLog.Calls.DATE);
            int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
            int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
            int name = cursor.getColumnIndex(CallLog.Calls.CACHED_NAME);

            String numberS = cursor.getString(number);
            Long dateS = cursor.getLong(date);
            String typeS = cursor.getString(type);
            String durationS = cursor.getString(duration);
            String nameS = cursor.getString(name);

            String tipollamada = "";

            switch (type) {
                case CallLog.Calls.INCOMING_TYPE:
                    tipollamada = getString(R.string.entrada);
                    break;
                case CallLog.Calls.OUTGOING_TYPE:
                    tipollamada = getString(R.string.salida);
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    tipollamada = getString(R.string.perdida);
                    break;
                default:
                    tipollamada = getString(R.string.indefinida);
            }

            String detail = getString(R.string.number) + " " + numberS + "\n"
                    + getString(R.string.date) + " " + DateFormat.format("dd/MM/YY k:mm:ss", dateS) + "\n"
                    + getString(R.string.type) + " " + tipollamada + "\n"
                    + getString(R.string.duration) + " " + durationS + "\n"
                    + getString(R.string.name) + " " + nameS + "\n\n";

            txtLlamadas.append(detail);

        }

    }
}
