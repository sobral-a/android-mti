package com.epita.mti.velibapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alexa on 26/05/2017.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter
{
    public SectionsPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        return PlaceholderFragment.newInstance(MyAdapter.mDataset.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return "SECTION";
    }

    @Override
    public int getCount()
    {
        return MyAdapter.mDataset.size();
    }
}
