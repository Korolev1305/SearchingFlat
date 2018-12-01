package com.example.ewigkeit.searching_flat.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Entity(foreignKeys = @ForeignKey(
        entity = Estate.class,
        parentColumns = "id",
        childColumns = "estateId"
))
public class Photos {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String url;

    private int estateId;

    public Photos(String name, String url, int estateId) {
        this.name = name;
        this.url = url;
        this.estateId = estateId;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
