package com.example.greekhoroscope.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.greekhoroscope.db.dao.HoroDao;
import com.example.greekhoroscope.db.entity.HoroEntity;

@Database(entities = {HoroEntity.class}, version = 1)
public abstract class HoroDataBase extends RoomDatabase {
    private static final String DB_NAME = "HoroDB";
    private static HoroDataBase instance;

    public static synchronized HoroDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), HoroDataBase.class,
                    DB_NAME).allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract HoroDao horoDao();
}
