package com.gorrotowi.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gorro on 08/10/15.
 */
public class MiLoader extends AsyncTaskLoader<List> {

    public MiLoader(Context context) {
        super(context);
    }

    @Override
    public List loadInBackground() {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            lista.add(getContext().getString(R.string.number) + i);
        }
        return lista;
    }
}
