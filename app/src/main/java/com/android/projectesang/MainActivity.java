package com.android.projectesang;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
    String nombre, quantitat,text;
    TextView textt;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView navList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("com.android.projectesang", Context.MODE_PRIVATE);
        nombre = prefs.getString("nombre", "");
        quantitat = prefs.getString("quantitat", "");
        textt = (TextView) findViewById(R.id.textinici);
        text = "Hola "+nombre+", has donat "+quantitat+" cops!";
        textt.setText(text);

       /*
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        String[] names = getResources().getStringArray(R.array.nav_drawer_items);
        this.navList = (ListView) findViewById(R.id.left_drawer);
        // Set previous array as adapter of the list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(new DrawerItemClickListener());
        */
        
    }

/*
    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            mDrawerLayout.closeDrawer(navList);
            navClic(position);
        }
    }

    private void navClic(int pos) {
        switch (pos) {
            case 1:

                break;
            case 2:

                break;
            default:
                break;
        }
    }*/

}
