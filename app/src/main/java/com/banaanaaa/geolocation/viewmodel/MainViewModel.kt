package com.banaanaaa.geolocation.viewmodel

import android.app.Application
import android.location.Location
import androidx.lifecycle.*
import com.banaanaaa.geolocation.model.entity.Point
import com.banaanaaa.geolocation.model.storage.PointRoomDatabase
import com.banaanaaa.geolocation.model.storage.Repository
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository = Repository(
        PointRoomDatabase.getDatabase(application, viewModelScope).pointDao()
    )
    private lateinit var points: LiveData<List<Point>>
    private var mMarkers = HashMap<String, Marker>()
    private var mPoints = HashMap<String, Point>()
    private var mMap: GoogleMap? = null
    private var mSelectedPointName = "-909"

    init {
        viewModelScope.launch(IO) {
            points = repository.getPoints()
        }
    }

    fun getPoints(): LiveData<List<Point>> {
        return points
    }

    fun getPoint(id: Int): LiveData<Point> {
        return repository.getPoint(id)
    }

    fun insertPoint(point: Point) = viewModelScope.launch(IO) {
        repository.insertPoint(point)
    }

    fun updatePoint(point: Point) = viewModelScope.launch(IO) {
        repository.updatePoint(point)
    }

    fun deletePoint(point: Point) = viewModelScope.launch(IO) {
        repository.deletePoint(point)
    }

    fun deletePoints() = viewModelScope.launch(IO) {
        repository.deletePoints()
    }

    fun addPoint(point: Point): NameValidationResult {
        val result = checkPointName(point.name)
        if (result == NameValidationResult.SUCCESS) {
            saveMarker(point)
            savePoint(point)
            insertPoint(point)
        }
        return result
    }

    fun renamePoint(point: Point, name: String): NameValidationResult {
        val result = checkPointName(name)
        if (result == NameValidationResult.SUCCESS) {
            val oldName = point.name
            point.name = name
            renameMarker(oldName, point)
            updatePoint(point)
        }
        return result
    }

    fun checkPointName(name: String): NameValidationResult {
        return when (name.length) {
            in 0..7 -> {
                NameValidationResult.TOO_SHORT
            }
            in 8..25 -> {
                // добавить проверку на уникальность
                NameValidationResult.SUCCESS
            }
            else -> {
                NameValidationResult.TOO_LONG
            }
        }
    }

    fun saveMap(map: GoogleMap) {
        mMap = map
    }

    fun loadMap() = mMap

    fun loadList(list: List<Point>) {
        list.forEach { point ->
            saveMarker(point)
            savePoint(point)
        }
    }

    fun savePoint(point: Point) {
        mPoints[point.name] = point
    }

    fun saveMarker(point: Point) {
        mMarkers[point.name] = mMap!!.addMarker(
            MarkerOptions()
                .position(LatLng(point.latitude, point.longitude))
                .title(point.name)
        )
    }

    private fun renameMarker(oldName: String, point: Point) {
        mMarkers[oldName]?.title = point.name
    }

    fun deleteMarker(point: Point) {
        mMarkers[point.name]?.remove()
        mMarkers.remove(point.name)
        mPoints.remove(point.name)
    }

    fun deleteMarkers() {
        mMarkers.clear()
        mPoints.clear()
    }

    fun selectMarker(point: Point) {
        mMarkers[point.name]?.setIcon(
            BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
        )
        mSelectedPointName = point.name
        moveCamera(point)
    }

    fun returnIcon() {
        if (mSelectedPointName != "-909") {
            mMarkers[mSelectedPointName]?.setIcon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
            )
            mSelectedPointName = "-909"
        }
    }

    private fun moveCamera(point: Point) {
        mMap!!.moveCamera(CameraUpdateFactory
                .newCameraPosition(CameraPosition.Builder()
                        .target(LatLng(point.latitude, point.longitude))
                        .zoom(16f).build()))
    }

    fun checkDistance(accuracy: Int, location: Location) : Boolean {
        mPoints.forEach { point ->
            if (location.distanceTo(point.value.getLocation()) <= accuracy) {
                return false
            }
        }
        return true
    }


    enum class NameValidationResult {
        TOO_SHORT, TOO_LONG, ALREADY_EXISTS, SUCCESS
    }
}