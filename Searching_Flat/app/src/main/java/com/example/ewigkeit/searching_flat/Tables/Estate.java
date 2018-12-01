package com.example.ewigkeit.searching_flat.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Entity(foreignKeys = {
        @ForeignKey(
                entity = Address.class,
                parentColumns = "id",
                childColumns = "addressId"
        ),
        @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "userId"
        ),
        @ForeignKey(
                entity = FlatType.class,
                parentColumns = "id",
                childColumns = "flatTypeId"
        ),
        @ForeignKey(
                entity = RepairType.class,
                parentColumns = "id",
                childColumns = "repairTypeId"
        ),
})
public class Estate {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int addressId;

    private int roomNumber;

    private int square;

    private int userId;

    private int flatTypeId;

    private int repairTypeId;

    private String cost;

    private int balcon;

    public Estate(int addressId, int roomNumber, int square, int userId, int flatTypeId, int repairTypeId, String cost, int balcon) {
        this.addressId = addressId;
        this.roomNumber = roomNumber;
        this.square = square;
        this.userId = userId;
        this.flatTypeId = flatTypeId;
        this.repairTypeId = repairTypeId;
        this.cost = cost;
        this.balcon = balcon;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public int getAddressId() {
        return addressId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getSquare() {
        return square;
    }

    public int getUserId() {
        return userId;
    }

    public int getFlatTypeId() {
        return flatTypeId;
    }

    public int getRepairTypeId() {
        return repairTypeId;
    }

    public String getCost() {
        return cost;
    }

    public int getBalcon() {
        return balcon;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}

