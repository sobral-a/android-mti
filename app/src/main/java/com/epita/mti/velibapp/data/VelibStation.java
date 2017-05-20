package com.epita.mti.velibapp.data;

/**
 * Created by alexa on 19/05/2017.
 */

public class VelibStation
{
    private final String recordid;
    private final StationFields fields;

    public VelibStation(String recordid, StationFields fields)
    {
        this.recordid = recordid;
        this.fields = fields;
    }

    public String getRecordid()
    {
        return recordid;
    }

    public StationFields getFields()
    {
        return fields;
    }
}

