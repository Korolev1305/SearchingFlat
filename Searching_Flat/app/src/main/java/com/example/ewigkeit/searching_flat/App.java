package com.example.ewigkeit.searching_flat;

import android.app.Application;
import android.arch.persistence.room.Room;

/**
 * Created by ewigkeit on 01/12/2018.
 */

public class App extends Application {

    private static DatabaseHelper db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), DatabaseHelper.class, "database")
                .allowMainThreadQueries()
                .build();
    }



    public static DatabaseHelper getDatabaseInstance() {
        return db;
    }
}
