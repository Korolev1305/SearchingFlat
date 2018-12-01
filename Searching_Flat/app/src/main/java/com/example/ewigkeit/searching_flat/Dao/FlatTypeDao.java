package com.example.ewigkeit.searching_flat.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.searching_flat.Tables.FlatType;

import java.util.List;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Dao
public interface FlatTypeDao {
    @Insert
    void insert(FlatType flatType);

    @Delete
    void delete(FlatType flatType);

    @Query("SELECT * FROM FlatType")
    List<FlatType> getAllData();

    @Query("SELECT * FROM FlatType WHERE id LIKE :id")
    FlatType getFlatTypeById(int id);

    @Query("SELECT * FROM FlatType WHERE description LIKE :description")
    FlatType getFlatTypeEquals(String description);

}
