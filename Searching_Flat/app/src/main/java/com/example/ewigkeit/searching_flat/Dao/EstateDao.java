package com.example.ewigkeit.searching_flat.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.searching_flat.Tables.Estate;

import java.util.List;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Dao
public interface EstateDao {
    @Insert
    void insert(Estate estate);

    @Delete
    void delete(Estate estate);

    @Query("SELECT * FROM Estate")
    List<Estate> getAllData();

    @Query("SELECT * FROM Estate WHERE id LIKE :id")
    Estate getEstateById(int id);

}
