package com.banaanaaa.geolocation.util

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*
import kotlin.collections.HashMap

class Navigation : LifecycleObserver {
    companion object {
        private var sInstance = Navigation()
        fun getNavigation() = sInstance
    }

    private var mContext: Context? = null
    private var mFragments = HashMap<Int, Fragment>()
    private var mNames = HashMap<Int, String>()
    private var mHomeFragmentId: Int? = null
    private var mFragmentManager: FragmentManager? = null
    private var mContainer: Int? = null
    private lateinit var mBottomNavigation: BottomNavigationView

    private var mActiveFragment: Fragment? = null
    private var mActiveId: Int? = null
    private var mBackStack = LinkedHashSet<Int>()

    fun setContext(context: Context) {
        mContext = context
    }

    fun setFragments(map: HashMap<Int, String>, id: Int) {
        mNames = map
        mHomeFragmentId = id
    }

    fun setBottomNavigation(bottom: BottomNavigationView) {
        mBottomNavigation = bottom

        mBottomNavigation.setOnNavigationItemSelectedListener { item ->
            showFragmentById(item.itemId)
            addToBackStack(item.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }

    fun setFragmentManager(fragmentManager: FragmentManager?) {
        mFragmentManager = fragmentManager
    }

    fun setContainer(container: Int) {
        mContainer = container
    }

    private fun createFragmentFromClassName(name: String) : Fragment {
        return Class.forName(name).getConstructor().newInstance() as Fragment
    }

    private fun createFragmentById(id: Int) {
        if (mFragments[id] == null) {
            mFragments[id] = createFragmentFromClassName(mNames[id]!!)
        }
    }

    fun showFragmentById(id: Int) {
        if (mFragmentManager == null) {
            return
        }
        if (mActiveFragment != null && mActiveFragment == mFragments[id]) {
            return
        }
        val transaction = mFragmentManager!!.beginTransaction()
        if (mActiveFragment != null) {
            transaction.hide(mActiveFragment!!)
            mActiveFragment!!.onStop()
        }
        if (mFragmentManager!!.findFragmentByTag("bottom#$id") == null) {
            createFragmentById(id)
            transaction.add(mContainer!!, mFragments[id]!!, "bottom#$id")
        } else {
            transaction.show(mFragments[id]!!)
            mFragments[id]!!.onStart()
        }
        mActiveFragment = mFragments[id]
        mActiveId = id
        setSelectedItem()
        transaction.commit()
    }

    fun shutdown(): Boolean {
        if (mBackStack.isNotEmpty()) {
            var id = mBackStack.last()
            mBackStack.remove(id)
            id = if (mBackStack.size == 0) {
                if (id == mHomeFragmentId) {
                    mBackStack.add(id)
                    return true
                }
                mBackStack.add(mHomeFragmentId as Int)
                mHomeFragmentId as Int
            } else {
                mBackStack.last()
            }
            showFragmentById(id)
            return false
        }
        return true
    }

    fun addToBackStack(id: Int) {
        if (mBackStack.contains(id)) {
            mBackStack.remove(id)
        }
        mBackStack.add(id)
    }

    private fun setSelectedItem() {
        mBottomNavigation.selectedItemId = mActiveId as Int
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        if (mActiveFragment == null) {
            showFragmentById(mHomeFragmentId!!)
            addToBackStack(mHomeFragmentId!!)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Utility.showToast(mContext!!, "Destroy")
        mFragmentManager = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }
}
