package com.epita.mti.velibapp.data;

/**
 * Created by alexa on 20/05/2017.
 */

public class StationFields
{
    private final String status;
    private final String contract_name;
    private final String name;
    private final String bonus;
    private final int bike_stands;
    private final int number;
    private final String last_update;
    private final int available_bike_stands;
    private final String banking;
    private final int available_bikes;
    private final String address;

    public StationFields(String status, String contract_name, String name, String bonus, int bike_stands, int number, String last_update, int available_bike_stands, String banking, int available_bikes, String address)
    {
        this.status = status;
        this.contract_name = contract_name;
        this.name = name;
        this.bonus = bonus;
        this.bike_stands = bike_stands;
        this.number = number;
        this.last_update = last_update;
        this.available_bike_stands = available_bike_stands;
        this.banking = banking;
        this.available_bikes = available_bikes;
        this.address = address;
    }

    public String getStatus()
    {
        return status;
    }

    public String getContract_name()
    {
        return contract_name;
    }

    public String getName()
    {
        return name;
    }

    public String getBonus()
    {
        return bonus;
    }

    public int getBike_stands()
    {
        return bike_stands;
    }

    public int getNumber()
    {
        return number;
    }

    public String getLast_update()
    {
        return last_update;
    }

    public int getAvailable_bike_stands()
    {
        return available_bike_stands;
    }

    public String getBanking()
    {
        return banking;
    }

    public int getAvailable_bikes()
    {
        return available_bikes;
    }

    public String getAddress()
    {
        return address;
    }
}
