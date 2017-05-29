package com.epita.mti.velibapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epita.mti.velibapp.data.VelibStation;

/**
 * Created by alexa on 27/05/2017.
 */

public class PlaceholderFragment extends Fragment
{
    private String name;
    private String status;
    private int bikeStands;
    private int available_bike_stands;
    private String adress;
    private String updateDate;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static PlaceholderFragment newInstance(int sectionNumber, VelibStation velibStation)
    {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //bikeStands = getArguments().getInt("someInt", 0);
        //status = getArguments().getString("someTitle");
        //TODO: GET strings and ints to display in view
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.pageview_fragment, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.firstlabel);
        textView.setText("Test view pager " + getArguments().getInt(ARG_SECTION_NUMBER) );
        return rootView;
    }

}
