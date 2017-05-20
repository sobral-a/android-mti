package com.epita.mti.velibapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alexa on 20/05/2017.
 */

public class JSONdata
{
    private final int nhits;
    private final List<VelibStation> records;

    public JSONdata(int nhits, List<VelibStation> records)
    {
        this.nhits = nhits;
        this.records = records;
    }

    public int getNhits()
    {
        return nhits;
    }

    public List<VelibStation> getRecords()
    {
        return records;
    }
}
