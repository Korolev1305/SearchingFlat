package com.example.ewigkeit.searching_flat.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.searching_flat.Tables.District;

import java.util.List;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Dao
public interface DistrictDao {
    @Insert
    void insert(District district);

    @Delete
    void delete(District district);

    @Query("SELECT * FROM District")
    List<District> getAllData();

    @Query("SELECT * FROM District WHERE id LIKE :id")
    District getDistrictById(int id);

    @Query("SELECT * FROM District WHERE description LIKE :description")
    District getDistrictEquals(String description);

}
