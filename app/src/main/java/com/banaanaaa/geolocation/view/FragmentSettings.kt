package com.banaanaaa.geolocation.view

import android.os.Bundle
import android.text.InputFilter
import android.text.InputType
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SeekBarPreference
import com.banaanaaa.geolocation.R
import com.banaanaaa.geolocation.util.FilterNumber

class FragmentSettings : PreferenceFragmentCompat() {

    override fun onCreate(savedInstanceState: Bundle?) {
        retainInstance = true
        super.onCreate(savedInstanceState)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)

        val mAccuracySeekBar: SeekBarPreference? = preferenceManager.findPreference("accuracy")
        val mEditTextSampleRate: EditTextPreference? = preferenceManager.findPreference("sample_rate")


        mEditTextSampleRate!!.setOnBindEditTextListener {
            it.inputType = InputType.TYPE_CLASS_NUMBER
            it.filters = arrayOf<InputFilter>(
                FilterNumber(
                    1,
                    30
                )
            )
        }
    }
}