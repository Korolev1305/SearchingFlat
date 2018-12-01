package com.example.ewigkeit.searching_flat.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.searching_flat.Tables.RepairType;

import java.util.List;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Dao
public interface RepairTypeDao {
    @Insert
    void insert(RepairType repairType);

    @Delete
    void delete(RepairType repairType);

    @Query("SELECT * FROM RepairType")
    List<RepairType> getAllData();

    @Query("SELECT * FROM RepairType WHERE id LIKE :id")
    RepairType getRepairTypeById(int id);

    @Query("SELECT * FROM RepairType WHERE description LIKE :description")
    RepairType getRepairTypeEquals(String description);

}
