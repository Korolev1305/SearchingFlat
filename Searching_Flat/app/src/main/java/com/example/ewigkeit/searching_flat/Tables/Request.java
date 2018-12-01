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
            entity = User.class,
            parentColumns = "id",
            childColumns = "userId"
        ),
        @ForeignKey(
                entity = Estate.class,
                parentColumns = "id",
                childColumns = "estateId"
        )
        }
)
public class Request {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int userId;

    private int estateId;

    public Request(int userId, int estateId) {
        this.userId = userId;
        this.estateId = estateId;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getEstateId() {
        return estateId;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
