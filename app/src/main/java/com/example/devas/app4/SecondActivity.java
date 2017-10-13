package com.example.devas.app4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by devas on 10/11/2017.
 */

public class SecondActivity extends AppCompatActivity implements RecyclerViewFragment.OnListItemSelectedListener{

    MovieData movieData = new MovieData();
    Toolbar standaloneToolbar ;
    RecyclerViewFragment recyclerFragment=new RecyclerViewFragment();

   // final RecyclerAdapter recyclerViewAdapter = new RecyclerAdapter(getBaseContext(),movieData.getMoviesList());


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.layoutforsecondactivity);

        Toolbar toolbar = (Toolbar)findViewById(R.id.activity2_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Movie List");
        getSupportActionBar().setLogo(R.drawable.emoticon_black);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

       // standaloneToolbar = (Toolbar)findViewById(R.id.bottomToolbar);
        standaloneToolbar = (Toolbar)findViewById(R.id.bottomToolbar);
        standaloneToolbar.inflateMenu(R.menu.menuforbottomtoolbar);
        setUpStandaloneToolbar();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerforlist2, RecyclerViewFragment.newInstance(R.id.cardlist))
                .commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menufilefrontpage, menu);
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

            case R.id.show:
                standaloneToolbar.setVisibility(View.VISIBLE);
                return true;


        }
        return true;
    }


    void setUpStandaloneToolbar()
    {
        //Toolbar standaloneToolbar = (Toolbar)findViewById(R.id.bottomToolbar);
        //standaloneToolbar.inflateMenu(R.menu.menuforbottomtoolbar);
        standaloneToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch(id)
                {
                    case R.id.sort_alphabetical :
                        RecyclerViewFragment.sortByName();
                        /*Collections.sort(movieData.getMoviesList(), new Comparator<Map<String, ?>>() {
                            @Override
                            public int compare(Map<String, ?> o1, Map<String, ?> o2) {
                                return o2.get("name").toString().compareTo(o1.get("name").toString());
                            }

                        });
                        recyclerViewAdapter.notifyDataSetChanged();*/
                        break;

                    case R.id.sort_numeric:
                        RecyclerViewFragment.sortByYear();
                        /*Collections.sort(movieData.getMoviesList(), new Comparator<Map<String, ?>>() {
                            @Override
                            public int compare(Map<String, ?> o1, Map<String, ?> o2) {
                                return o2.get("name").toString().compareTo(o1.get("name").toString());
                            }

                        });
                        recyclerViewAdapter.notifyDataSetChanged();*/
                }
                return false;
            }

        });

        standaloneToolbar.setNavigationIcon(R.drawable.step_forward);
        standaloneToolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                standaloneToolbar.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void OnListItemSelected(int position, HashMap<String, ?> movie) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerforlist2,Movie_details_fragment.newInstance(movie))
                .addToBackStack(null).commit();
    }
}

