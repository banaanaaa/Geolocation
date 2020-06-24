package com.banaanaaa.geolocation.view

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.banaanaaa.geolocation.R
import com.banaanaaa.geolocation.model.entity.Point
import com.banaanaaa.geolocation.util.Utility
import com.banaanaaa.geolocation.viewmodel.MainViewModel
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.dialog_input.view.*
import kotlinx.android.synthetic.main.dialog_new_point.view.*
import kotlinx.android.synthetic.main.fragment_map.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("MissingPermission")
class FragmentMap : Fragment(), OnMapReadyCallback {

    companion object {
        private const val LOCATION_REQUEST_CODE = 3489
    }

    private lateinit var mViewModel: MainViewModel

    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private var mMap: GoogleMap? = null

    private var mLocation = Location("")

    private var mPermissions: Boolean = false
    private var mMapView: View? = null

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            mLocation = locationResult.lastLocation
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        retainInstance = true
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(false)
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(activity!!).get(MainViewModel::class.java)

        requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_REQUEST_CODE)

        buttonAddPosition.setOnClickListener {
            if (mPermissions) {
                if (checkDistance()) {
                    showDialog()
                } else {
                    Utility.showToast(activity!!, "Рядом уже есть точка")
                }
            } else {
                Utility.showToast(activity!!, "Отсутствуют необходимые разрешения")
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = mViewModel.loadMap()
        if (mMap == null) {
            mMap = googleMap
            mMap!!.isMyLocationEnabled = true
            mMap!!.uiSettings.isZoomControlsEnabled = true
            mMap!!.uiSettings.isMapToolbarEnabled = false

            val orientation = activity!!.windowManager.defaultDisplay.rotation
            if (orientation == 1 || orientation == 3) {
                redrawZoomButtons(true)
            } else {
                redrawZoomButtons(false)
            }

            mViewModel.saveMap(mMap!!)
            mViewModel.getPoints().observe(this, Observer { list ->
                if (list.isNotEmpty()) {
                    mViewModel.loadList(list)
                }
                mViewModel.getPoints().removeObservers(this)
            })

            if (!mPermissions) {
                Utility.showToast(activity!!, "Отсутствуют необходимые разрешения")
                return
            }

            GlobalScope.launch(Dispatchers.Main) {
                requestNewLocationData()
                delay(2000)
                moveOnLastLocation()
            }
        }
    }

    private fun checkDistance(): Boolean {
        val settings = PreferenceManager.getDefaultSharedPreferences(activity!!)
        val accuracy = settings.getInt("accuracy", 100)

        requestNewLocationData()

        return mViewModel.checkDistance(accuracy, mLocation)
    }

    private fun showDialog() {
        requestNewLocationData()

        val dialogLayout = layoutInflater.inflate(R.layout.dialog_new_point, null)
        val name = dialogLayout.name_edittext.text
        val layout = dialogLayout.input_layout

        dialogLayout.latitude_textview.text = getString(R.string.dialog_new_point_latitude)
                .format(mLocation.latitude)
        dialogLayout.longitude_textview.text = getString(R.string.dialog_new_point_longitude)
                .format(mLocation.longitude)

        val dialog = Utility.createDialog(
            activity!!,
            getString(R.string.dialog_new_point_title), dialogLayout
        )

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val point = Point(name.toString(), mLocation.latitude, mLocation.longitude)
                when (mViewModel.addPoint(point)) {
                    MainViewModel.NameValidationResult.TOO_SHORT -> {
                        layout.error = getString(R.string.error_name_is_short)
                        Utility.showToast(activity!!, getString(R.string.toast_is_short))
                    }
                    MainViewModel.NameValidationResult.TOO_LONG -> {
                        layout.error = getString(R.string.error_name_is_long)
                        Utility.showToast(activity!!, getString(R.string.toast_is_long))
                    }
                    MainViewModel.NameValidationResult.ALREADY_EXISTS -> {
                        // будет скоро
                    }
                    MainViewModel.NameValidationResult.SUCCESS -> {
                        dialog.dismiss()
                        GlobalScope.launch(Dispatchers.Main) {
                            moveCameraOnLocation(point.latitude, point.longitude)
                        }
                    }
                }
            }
        }

        dialog.show()
    }

    private suspend fun moveCameraOnLocation(latitude: Double, longitude: Double) {
        mMap!!.moveCamera(CameraUpdateFactory
                .newCameraPosition(CameraPosition.Builder()
                        .target(LatLng(latitude, longitude))
                        .zoom(16f).build()))
    }

    fun checkRepos() {

    }

    private fun moveOnLastLocation() {
        if (activity != null) {
            mFusedLocationClient.lastLocation.addOnCompleteListener(activity!!) {
                val location: Location? = it.result
                if (location != null) {
                    GlobalScope.launch(Dispatchers.Main) {
                        moveCameraOnLocation(mLocation.latitude, mLocation.longitude)
                    }
                } else {
                    moveOnLastLocation()
                }
            }
        }
    }

    private fun requestNewLocationData() {
        val mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity!!)
        mFusedLocationClient.requestLocationUpdates(
            mLocationRequest, mLocationCallback, Looper.myLooper()
        )
    }

    private fun redrawZoomButtons(landscape: Boolean) {
        val zoom = mMapView?.findViewWithTag<View>("GoogleMapZoomOutButton")!!.parent as LinearLayout
        val param = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        if (landscape) {
            param.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
            param.setMargins(26, 0, 0, 0)
        } else {
            param.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            param.setMargins(0, 0, 26, 0)
        }

        zoom.layoutParams = param
        zoom.gravity = Gravity.CENTER_VERTICAL

        zoom.layoutParams.height = (mMapView!!.parent as View).height - zoom.marginBottom * 2
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                    || grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                val mMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
                mMapFragment?.getMapAsync(this)
                mMapView = mMapFragment?.view
                mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity!!)
                mPermissions = true
            } else {
                Utility.showToast(activity!!, "Ошибка получения разрешений")
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}

