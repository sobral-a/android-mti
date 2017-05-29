package com.epita.mti.velibapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by alexa on 26/05/2017.
 */

public class PagerActivity extends AppCompatActivity
{
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        Toolbar listToolBar = (Toolbar) findViewById(R.id.pagerToolBar);
        setSupportActionBar(listToolBar);

        FragmentManager fragmentManager = getSupportFragmentManager();

        mSectionsPagerAdapter = new SectionsPagerAdapter(fragmentManager);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater  = getMenuInflater();
        menuInflater.inflate(R.menu.pager_toolbar_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.pargermembers_list:
                displayMembers();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void displayMembers()
    {
        Intent displayMembers = new Intent(PagerActivity.this, MembersListActivity.class);
        startActivity(displayMembers);
    }
}