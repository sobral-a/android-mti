package com.epita.mti.velibapp.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alexa on 19/05/2017.
 */

public interface VelibService
{
    public static final String ENDPOINT = "https://opendata.paris.fr/";

    @GET("api/records/1.0/search/")
    Call<JSONdata> listVelibObjects(@Query("dataset") String dataset, @Query("rows") int rows);
}
