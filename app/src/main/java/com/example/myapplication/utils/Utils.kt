package com.example.myapplication.utils

import android.content.Context
import android.support.v7.app.AlertDialog

class Utils {
    companion object {
        @JvmStatic fun showErrorDialog(context: Context?, error: String) {
            val builder = context?.let { AlertDialog.Builder(it) }

            // Set the alert dialog title
            builder?.setTitle("Error")

            // Display a message on alert dialog
            builder?.setMessage(error)

            // Set a positive button and its click listener on alert dialog
            builder?.setPositiveButton("Okay"){dialog, _ ->
                dialog.dismiss()
            }

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog? = builder?.create()

            dialog?.setCancelable(false)

            // Display the alert dialog on app interface
            dialog?.show()
        }

        @JvmStatic fun showLoader(context: Context?) {
        }

        @JvmStatic fun hideLoader() {

        }
    }
}