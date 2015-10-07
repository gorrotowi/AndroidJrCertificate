package com.gorrotowi.dinamicfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Persona[] personas = {
                new Persona("Sebastian", "552014123", "@gorrotowi", "sebastian@mail.com"),
                new Persona("Itzael", "5521345234", "@itzael", "itzael@mail.com"),
                new Persona("Karla", "55223452323", "@karla", "karla@mail.com"),
                new Persona("Juan", "552345234", "@juan", "juan@mail.com"),
                new Persona("Carlos", "55605t045", "@carlos", "carlos@mail.com")};

        final ListView listView = (ListView) findViewById(R.id.listViewFragment);

        listView.setAdapter(new ItemAdapter(this, R.layout.item_persona, personas));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Persona persona = (Persona) listView.getAdapter().getItem(position);
                TextView txtDetalle = (TextView) findViewById(R.id.txtDetail);
                String detalle = getString(R.string.twitter) + getString(R.string.placeHolder) + persona.getTwitter() + getString(R.string.salto_linea) + getString(R.string.correo) + getString(R.string.placeHolder) + persona.getCorreo();
                txtDetalle.setText(detalle);
            }
        });

    }
}
