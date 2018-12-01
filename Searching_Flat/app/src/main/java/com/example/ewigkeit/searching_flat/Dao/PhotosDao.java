package com.example.ewigkeit.searching_flat.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.searching_flat.Tables.Address;
import com.example.ewigkeit.searching_flat.Tables.Photos;

import java.util.List;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Dao
public interface PhotosDao {
    @Insert
    void insert(Photos photos);

    @Delete
    void delete(Photos photos);

    @Query("SELECT * FROM Photos")
    List<Photos> getAllData();

    @Query("SELECT * FROM Photos WHERE id LIKE :id")
    List<Photos> getPhotosById(int id);

    @Query("SELECT * FROM Photos WHERE name LIKE :name AND url LIKE :url AND estateId LIKE :estateId")
    Photos getPhotosEquals(String name, String url, int estateId);


}
