package com.example.devas.app4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by devas on 9/27/2017.
 */

public class RecyclerViewClass extends AppCompatActivity implements RecyclerViewFragment.OnListItemSelectedListener  {

    MovieData movieData = new MovieData();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_view);

        Toolbar toolbar = (Toolbar)findViewById(R.id.activity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Movie List");
        getSupportActionBar().setLogo(R.drawable.emoticon_black);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerforlist, RecyclerViewFragment.newInstance(R.id.cardlist))
                .commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menufile, menu);
        return true;

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        Intent intent;
        switch (id)
        {
            case R.id.task1 :
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return  true;

            case R.id.task2 :
                intent = new Intent(this,RecyclerViewClass.class);
                startActivity(intent);
                return  true;

        }
        return true;
    }

    @Override
    public void OnListItemSelected(int position, HashMap<String, ?> movie) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerforlist,Movie_details_fragment.newInstance(movie))
                .addToBackStack(null).commit();
    }
}
