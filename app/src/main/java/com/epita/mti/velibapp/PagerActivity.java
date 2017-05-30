package com.epita.mti.velibapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.epita.mti.velibapp.data.StationFields;
import com.epita.mti.velibapp.data.VelibStation;

import java.util.List;

/**
 * Created by alexa on 26/05/2017.
 */

public class PagerActivity extends AppCompatActivity
{
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_pager);

        Toolbar childToolbar = (Toolbar) findViewById(R.id.pagerToolBar);
        if (childToolbar != null)
        {
            childToolbar.setTitle("Station Details");
            childToolbar.setLogo(R.drawable.details);
            setSupportActionBar(childToolbar);
        }

        ActionBar ab = getSupportActionBar();
        if (ab != null)
        {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        mSectionsPagerAdapter = new SectionsPagerAdapter(fragmentManager);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(getIntent().getIntExtra("currentPosition", 0));

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
            case R.id.action_share:
                share();
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

    private void share()
    {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");

        int currIndex = mViewPager.getCurrentItem();
        StationFields station = MyAdapter.mDataset.get(currIndex).getFields();
        sendIntent.putExtra(Intent.EXTRA_TEXT, station.getAddress());
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(sendIntent, PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe)
        {
            startActivity(Intent.createChooser(sendIntent, "Share station details ..."));
        }
    }
}