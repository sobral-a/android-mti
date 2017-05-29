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
        return PlaceholderFragment.newInstance(position + 1, null);
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case  0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return 0;
    }
}
