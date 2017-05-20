package com.epita.mti.velibapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epita.mti.velibapp.data.VelibStation;

import java.util.ArrayList;

import java.util.List;

/**
 * Created by alexa on 19/05/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private List<VelibStation> mDataset = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTextView;
        public ViewHolder(View v)
        {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.list_text);
        }
    }


    public void setData(List<VelibStation> myDataSet)
    {
        this.mDataset = myDataSet;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.mTextView.setText(mDataset.get(position).getFields().getName());
    }

    @Override
    public int getItemCount()
    {
        return mDataset.size();
    }
}
