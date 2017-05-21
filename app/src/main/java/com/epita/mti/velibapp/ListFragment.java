package com.epita.mti.velibapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epita.mti.velibapp.data.JSONdata;
import com.epita.mti.velibapp.data.VelibService;
import com.epita.mti.velibapp.data.VelibStation;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.System.in;

/**
 * Created by alexa on 19/05/2017.
 */

public class ListFragment extends Fragment
{
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.myRecycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(VelibService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create()).build();
        VelibService velibService = retrofit.create(VelibService.class);

        final Call<JSONdata> objectList = velibService.listVelibObjects("stations-velib-disponibilites-en-temps-reel", 100);
        objectList.enqueue(new Callback<JSONdata>()
        {
            @Override
            public void onResponse(Call<JSONdata> call, Response<JSONdata> response)
            {
                if (response.isSuccessful())
                {
                    JSONdata jsonData = response.body();
                    List<VelibStation> velibStations = jsonData.getRecords();
                    mAdapter.setData(velibStations);
                    mAdapter.notifyDataSetChanged();
                }
                else
                {
                    Log.d("Failure not successful",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<JSONdata> call, Throwable t)
            {
                Log.d("Failure Onfailure",t.getCause().toString());
            }
        });
    }
}