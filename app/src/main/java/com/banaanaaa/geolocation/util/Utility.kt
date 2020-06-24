package com.banaanaaa.geolocation.util

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.Toast

class Utility {
    companion object {
        fun showToast(context: Context, text: String, duration: Int) {
            Toast.makeText(context, text, duration).show()
        }

        fun showToast(context: Context, text: String) {
            showToast(context, text, Toast.LENGTH_SHORT)
        }

        fun createDialog(
            context: Context,
            title: String, view: View
        ) : AlertDialog = AlertDialog.Builder(context)
            .setTitle(title)
            .setView(view)
            .setPositiveButton("OK", null)
            .setNegativeButton("Cancel", null)
            .create()
    }
}