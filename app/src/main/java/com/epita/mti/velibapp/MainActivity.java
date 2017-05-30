package com.epita.mti.velibapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
{
    private ListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar listToolBar = (Toolbar) findViewById(R.id.listToolBar);
        setSupportActionBar(listToolBar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ListFragment fragment = new ListFragment();
        this.fragment = fragment;

        fragmentTransaction.add(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.list_toolbar_menu, menu);

        handleSearch(menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void handleSearch(Menu menu)
    {
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                fragment.getmAdapter().filter(query);
                fragment.getmRecyclerView().scrollToPosition(0);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                fragment.getmAdapter().filter(newText);
                fragment.getmRecyclerView().scrollToPosition(0);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.members_list:
                displayMembers();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void displayMembers()
    {
        Intent displayMembers = new Intent(MainActivity.this, MembersListActivity.class);
        startActivity(displayMembers);
    }
}
