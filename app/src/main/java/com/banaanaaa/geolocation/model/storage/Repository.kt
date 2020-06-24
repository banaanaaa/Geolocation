package com.banaanaaa.geolocation.model.storage

import androidx.lifecycle.LiveData
import com.banaanaaa.geolocation.model.entity.Point
import com.banaanaaa.geolocation.model.storage.dao.PointDao

class Repository(private val pointDao: PointDao) {

    fun getPoints(): LiveData<List<Point>> {
        return pointDao.select()
    }

    fun getPoint(id: Int): LiveData<Point> {
        return pointDao.select(id)
    }

    suspend fun insertPoint(point: Point) {
        pointDao.insert(point)
    }

    suspend fun updatePoint(point: Point) {
        pointDao.update(point)
    }

    suspend fun deletePoint(point: Point) {
        pointDao.delete(point)
    }

    suspend fun deletePoints() {
        pointDao.delete()
    }
}