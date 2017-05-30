package com.epita.mti.velibapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by alexa on 22/05/2017.
 */

public class MembersListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_members_activity);

        Toolbar childToolbar = (Toolbar) findViewById(R.id.members_list_toolbar);
        if (childToolbar != null)
        {
            childToolbar.setTitle("Members List");
            childToolbar.setLogo(R.drawable.people);
            setSupportActionBar(childToolbar);
        }

        ActionBar ab = getSupportActionBar();
        if (ab != null)
        {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
}
