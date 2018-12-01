package com.example.ewigkeit.searching_flat.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.searching_flat.Tables.Request;

import java.util.List;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Dao
public interface RequestDao {
    @Insert
    void insert(Request request);

    @Delete
    void delete(Request request);

    @Query("SELECT * FROM Request")
    List<Request> getAllData();

    @Query("SELECT * FROM Request WHERE id LIKE :id")
    List<Request> getRequestById(int id);

}
