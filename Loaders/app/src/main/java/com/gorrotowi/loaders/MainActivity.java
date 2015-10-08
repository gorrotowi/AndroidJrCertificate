package com.gorrotowi.loaders;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List> {

    public static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoaderManager().initLoader(1, null, this).forceLoad();
    }

    public void loader(View v) {

        i++;
        Toast.makeText(MainActivity.this, getString(R.string.click_toast_string) + i, Toast.LENGTH_SHORT).show();

    }

    @Override
    public Loader<List> onCreateLoader(int i, Bundle bundle) {
        return new MiLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List> loader, List list) {
        ListView listView = (ListView) findViewById(R.id.listVLoader);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<List> loader) {

    }
}
