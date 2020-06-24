package com.banaanaaa.geolocation.model.storage.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.banaanaaa.geolocation.model.entity.Point


@Dao
interface PointDao {

    @Query("SELECT * FROM point_table")
    fun select(): LiveData<List<Point>>

    @Query("SELECT * FROM point_table WHERE id = :id")
    fun select(id: Int): LiveData<Point>

    @Insert
    suspend fun insert(point: Point)

    @Update
    suspend fun update(point: Point)

    @Delete
    suspend fun delete(point: Point)

    @Query("DELETE FROM point_table")
    suspend fun delete()
}