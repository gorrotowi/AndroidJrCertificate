package com.gorrotowi.dinamicfragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by gorro on 07/10/15.
 */
public class ItemAdapter extends ArrayAdapter<Persona> {
    Context context;
    Persona[] personas;
    int resource;


    public ItemAdapter(Context context, int resource, Persona[] personas) {
        super(context, resource, personas);
        this.context = context;
        this.personas = personas;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View adapterview = inflater.inflate(resource, null);

        TextView txtName = (TextView) adapterview.findViewById(R.id.txtItemName);
        TextView txtPhone = (TextView) adapterview.findViewById(R.id.txtItemPhone);

        txtName.setText(personas[position].getNombre());
        txtPhone.setText(personas[position].getTelefono());

        return adapterview;
    }
}
