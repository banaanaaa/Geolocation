package com.banaanaaa.geolocation.view

import android.content.res.Configuration
import android.hardware.SensorManager
import android.media.audiofx.BassBoost
import android.os.*
import android.view.OrientationEventListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.banaanaaa.geolocation.R
import com.banaanaaa.geolocation.util.Navigation
import com.banaanaaa.geolocation.util.Utility
import com.banaanaaa.geolocation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainViewModel
    private var mRotationListener: OrientationEventListener? = null

    private val mFragmentsMap = hashMapOf(
        R.id.map_dest to "com.banaanaaa.geolocation.view.FragmentMap",
        R.id.list_dest to "com.banaanaaa.geolocation.view.FragmentList",
        R.id.settings_dest to "com.banaanaaa.geolocation.view.FragmentSettings"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        setOrientationListener()

        lifecycle.addObserver(Navigation.getNavigation())

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        Navigation.getNavigation().setContext(applicationContext)
        Navigation.getNavigation().setContainer(R.id.fragment_container)
        Navigation.getNavigation().setFragmentManager(supportFragmentManager)
        Navigation.getNavigation().setFragments(mFragmentsMap, R.id.map_dest)
        Navigation.getNavigation().setBottomNavigation(bottom_navigation)
    }

    override fun onBackPressed() {
        if (Navigation.getNavigation().shutdown()) {
            super.onBackPressed()
        }
    }

    private fun setOrientationListener() {
        mRotationListener = object : OrientationEventListener(applicationContext,
                SensorManager.SENSOR_DELAY_NORMAL) {
            override fun onOrientationChanged(orientation: Int) {

            }
        }
    }

    override fun onStart() {
        mRotationListener?.enable()
        super.onStart()
    }

    override fun onStop() {
        mRotationListener?.disable()
        super.onStop()    }

}
