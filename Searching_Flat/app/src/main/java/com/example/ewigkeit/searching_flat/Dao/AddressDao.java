package com.example.ewigkeit.searching_flat.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ewigkeit.searching_flat.Tables.Address;

import java.util.List;

/**
 * Created by ewigkeit on 01/12/2018.
 */

@Dao
public interface AddressDao {
    @Insert
    void insert(Address address);

    @Delete
    void delete(Address address);

    @Query("SELECT * FROM Address")
    List<Address> getAllData();

    @Query("SELECT * FROM Address WHERE id LIKE :id")
    Address getAddressById(int id);

    @Query("SELECT * FROM Address WHERE districtId LIKE :districtId AND street LIKE :street AND house LIKE :house AND floor LIKE :floor")
    Address getAddressEquals(int districtId,String street,String house, int floor);

}
