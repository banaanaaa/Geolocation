package com.banaanaaa.geolocation.util

import android.text.InputFilter
import android.text.Spanned

class FilterNumber(private val min: Int, private val max: Int) : InputFilter {

    override fun filter(
        source: CharSequence, start: Int, end: Int,
        dest: Spanned, dstart: Int, dend: Int
    ): CharSequence? {
        if (isInRange((dest.toString() + source.toString()).toInt())) {
            return null
        }
        return ""
    }

    private fun isInRange(input: Int): Boolean {
        return input in min..max
    }
}