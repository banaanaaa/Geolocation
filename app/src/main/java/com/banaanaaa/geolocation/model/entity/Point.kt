package com.banaanaaa.geolocation.model.entity

import android.location.Location
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "point_table")
class Point() {

    @PrimaryKey(autoGenerate = true) var id = 0

    var name = ""
    var latitude = 0.0
    var longitude = 0.0

    constructor(
        name: String,
        latitude: Double,
        longitude: Double
    ) : this() {
        this.name = name
        this.latitude = latitude
        this.longitude = longitude
    }

    fun getLocation(): Location {
        val location = Location("")
        location.latitude = latitude
        location.longitude = longitude
        return location
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (id != other.id) return false
        if (name != other.name) return false
        if (latitude != other.latitude) return false
        if (longitude != other.longitude) return false

        return true
    }

    override fun hashCode(): Int {
        return id * 345
    }
}


