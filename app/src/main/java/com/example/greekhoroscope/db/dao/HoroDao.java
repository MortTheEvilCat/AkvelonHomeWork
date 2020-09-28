package com.example.greekhoroscope.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.greekhoroscope.db.entity.HoroEntity;

import java.util.List;

@Dao
public interface HoroDao {
    @Query("SELECT * FROM horo_table")
    List<HoroEntity> getAll();

    @Query("SELECT * FROM horo_table WHERE is_favourite = 1")
    List<HoroEntity> getFavourites();

    @Query("SELECT description FROM horo_table WHERE name = :name")
    String getDescriptionByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<HoroEntity> entities);

    @Update
    void update(HoroEntity entity);
}
