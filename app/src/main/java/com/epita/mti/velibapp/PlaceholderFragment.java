package com.epita.mti.velibapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaMetadataCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epita.mti.velibapp.data.VelibStation;

/**
 * Created by alexa on 27/05/2017.
 */

public class PlaceholderFragment extends Fragment
{
    private static final String ARG_NAME = "name";
    private static final String ARG_STATUS = "status";
    private static final String ARG_BIKESTANDS = "bikeStands";
    private static final String ARG_AVAILABLEBIKESTANDS = "availableBikeStands";
    private static final String ARG_ADRESS = "adress";
    private static final String ARG_UPDATEDATE = "updateDate";

    public static PlaceholderFragment newInstance(VelibStation velibStation)
    {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();

        args.putString(ARG_NAME, velibStation.getFields().getName());
        args.putString(ARG_STATUS, velibStation.getFields().getStatus());
        args.putInt(ARG_BIKESTANDS, velibStation.getFields().getBike_stands());
        args.putInt(ARG_AVAILABLEBIKESTANDS, velibStation.getFields().getAvailable_bike_stands());
        args.putString(ARG_ADRESS, velibStation.getFields().getAddress());
        args.putString(ARG_UPDATEDATE, velibStation.getFields().getLast_update());

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.pageview_fragment, container, false);
        TextView nameView = (TextView) rootView.findViewById(R.id.station_name);
        nameView.setText("Nom:  " + getArguments().getString(ARG_NAME).split("-")[1].trim());
        if (getArguments().getString(ARG_STATUS).equals("CLOSED"))
        {
            ImageView imgView = (ImageView) rootView.findViewById(R.id.statusImg);
            imgView.setImageResource(R.drawable.close);
            TextView statusView = (TextView) rootView.findViewById(R.id.station_status);
            statusView.setText("CLOSED");
        }
        TextView bikesView = (TextView) rootView.findViewById(R.id.station_bikestands);
        bikesView.setText(String.format("Bike Stands:  %d", getArguments().getInt(ARG_BIKESTANDS)));

        TextView availableView = (TextView) rootView.findViewById(R.id.station_available);
        availableView.setText("Available bike stands:  " + getArguments().getInt(ARG_AVAILABLEBIKESTANDS));

        TextView adressView = (TextView) rootView.findViewById(R.id.station_adress);
        adressView.setText("Adress:  " + getArguments().getString(ARG_ADRESS));

        TextView dateView = (TextView) rootView.findViewById(R.id.station_updatedate);
        dateView.setText("Last Update:  " + getArguments().getString(ARG_UPDATEDATE));

        return rootView;
    }

}
