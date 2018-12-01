package com.example.ewigkeit.searching_flat;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.example.ewigkeit.searching_flat.Dao.AddressDao;
import com.example.ewigkeit.searching_flat.Dao.DistrictDao;
import com.example.ewigkeit.searching_flat.Dao.EstateDao;
import com.example.ewigkeit.searching_flat.Dao.FlatTypeDao;
import com.example.ewigkeit.searching_flat.Dao.PhotosDao;
import com.example.ewigkeit.searching_flat.Dao.RepairTypeDao;
import com.example.ewigkeit.searching_flat.Dao.RequestDao;
import com.example.ewigkeit.searching_flat.Dao.UserDao;
import com.example.ewigkeit.searching_flat.Tables.Address;
import com.example.ewigkeit.searching_flat.Tables.District;
import com.example.ewigkeit.searching_flat.Tables.Estate;
import com.example.ewigkeit.searching_flat.Tables.FlatType;
import com.example.ewigkeit.searching_flat.Tables.Photos;
import com.example.ewigkeit.searching_flat.Tables.RepairType;
import com.example.ewigkeit.searching_flat.Tables.Request;
import com.example.ewigkeit.searching_flat.Tables.User;

/**
 * Created by ewigkeit on 01/12/2018.
 */

@Database(entities = {Address.class, District.class,Estate.class, FlatType.class, Photos.class,RepairType.class, Request.class, User.class},version = 1,exportSchema = false)
public abstract class DatabaseHelper  extends RoomDatabase {
    public abstract AddressDao getAddressDao();

    public abstract DistrictDao getDistrictDao();

    public abstract EstateDao getEstateDao();

    public abstract FlatTypeDao getFlatTypeDao();

    public abstract RepairTypeDao getRepairTypeDao();

    public abstract RequestDao getRequestDao();

    public abstract UserDao getUserDao();

    public abstract PhotosDao getPhotosDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
