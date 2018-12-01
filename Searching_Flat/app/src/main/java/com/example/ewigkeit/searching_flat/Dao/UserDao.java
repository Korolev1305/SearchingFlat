package com.example.ewigkeit.searching_flat.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.searching_flat.Tables.User;

import java.util.List;

/**
 * Created by ewigkeit on 01/12/2018.
 */
@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM User")
    List<User> getAllData();

    @Query("SELECT * FROM User WHERE id LIKE :id")
    List<User> getUserById(int id);


    @Query("SELECT * FROM User WHERE login LIKE :login AND password LIKE :password")
    User getUser(String login,String password);

}
