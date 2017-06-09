package com.flipelunico.flipreader;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.flipelunico.flipreader.adapter.Entry;
import com.flipelunico.flipreader.adapter.FeedListAdapter;
import com.flipelunico.flipreader.db.FeedlyDB;
import com.flipelunico.flipreader.parser.FeedlyParser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean LoadFromDB = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Cursor c = FeedlyDB.getInstance(this).getENTRIES("Android");

        if (c.getCount() > 0) {

            CargarVista();

        }else {
            LoadFromDB = false;
            boolean resultado = CargarFeeds();
        }

    }


    private boolean CargarFeeds()
    {
        /*FeedlyParser.getInstance(this).get_categories();

        FeedlyParser.getInstance(this).setCustomParserListener(new FeedlyParser.ParserListener() {
            @Override
            public void onParserReady(String continuation) {
                Log.i("Flipelunico","Evento ya termino parseo: " + continuation);
            }
        });

        Cursor cCat = FeedlyDB.getInstance(this).getCATEGORIES();

        while (cCat.moveToNext()) {
            FeedlyParser.getInstance(this).get_entries(cCat.getString(1));
        }
        cCat.close();

        return cCat;*/

        FeedlyParser.getInstance(this).setCustomParserListener(new FeedlyParser.ParserListener() {
            @Override
            public void onParserReady(String continuation) {
                Log.i("Flipelunico","Evento ya termino parseo: " + continuation);
                if (!LoadFromDB){
                    CargarVista();
                }
            }
        });

        FeedlyParser.getInstance(this).get_entries("user/45572cdc-c7de-425f-bc9a-11e08b224fab/category/Android");

        return true;

    }

    private void CargarVista()
    {
        Cursor c = FeedlyDB.getInstance(this).getENTRIES("Android");

        mAdapter = new FeedListAdapter(c,this);
        mRecyclerView.setAdapter(mAdapter);

        LoadFromDB = true;
    }
}
