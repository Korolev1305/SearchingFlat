package com.example.ewigkeit.searching_flat.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Entity(foreignKeys = @ForeignKey(
        entity = District.class,
        parentColumns = "id",
        childColumns = "districtId"
))
public class Address {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int districtId;

    private String street;

    private String house;

    private int floor;

    @NonNull
    public int getId() {
        return id;
    }

    public int getDistrictId() {
        return districtId;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public int getFloor() {
        return floor;
    }

    public Address(int districtId, String street, String house, int floor) {
        this.districtId = districtId;
        this.street = street;
        this.house = house;
        this.floor = floor;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
