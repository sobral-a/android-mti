package com.epita.mti.velibapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.epita.mti.velibapp.data.StationFields;
import com.epita.mti.velibapp.data.VelibStation;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by alexa on 19/05/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    public static List<VelibStation> mDataset = new ArrayList<>();
    private List<VelibStation> sourceList = new ArrayList<>();
    private Context context;

    public MyAdapter(Context context)
    {
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTextView;
        private ImageView statusIcon;
        public ViewHolder(View v)
        {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.list_text);
            statusIcon = (ImageView) v.findViewById(R.id.status_img);
        }
    }


    public void setData(List<VelibStation> myDataSet)
    {
        this.mDataset = myDataSet;
    }
    public List<VelibStation> getData()
    {
        return this.mDataset;
    }

    public void setSourceList(List<VelibStation> sourceList)
    {
        this.sourceList = sourceList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        final VelibStation station = mDataset.get(position);
        StationFields fields = station.getFields();
        String[] array = fields.getName().split("-");

        if (array.length > 2)
            holder.mTextView.setText(array[1].trim() + '-' + array[2].trim());
        else
            holder.mTextView.setText(array[1].trim());

        if (fields.getStatus().equals("CLOSED"))
        {
            holder.statusIcon.setImageResource(R.drawable.close);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                try
                {
                    Intent pagerActivity = new Intent(context, PagerActivity.class);
                    pagerActivity.putExtra("currentPosition", position);
                    context.startActivity(pagerActivity);
                }
                catch (Exception e)
                {
                    Log.d(TAG, "onClick: "+ e.getMessage().toString());
                }
            }
        });
    }


    @Override
    public int getItemCount()
    {
        return mDataset.size();
    }

    public void filter(String newText)
    {
        ArrayList<VelibStation> newList = new ArrayList<>();
        if (newText != null && !newText.trim().isEmpty())
        {
            for (VelibStation v : mDataset)
            {
                if (v.getFields().getAddress().trim().toLowerCase().contains(newText.toLowerCase().trim()))
                    newList.add(v);
            }
        }
        else
            newList = (ArrayList)sourceList;

        this.mDataset = newList;
        this.notifyDataSetChanged();
    }
}
