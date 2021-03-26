package com.pallotta.andrea.animals

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AboutDialog(): DialogFragment() {

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        return AlertDialog.Builder(activity).setTitle("About")
//                .setMessage("Created By Andrea Pallotta")
//                .create()
//    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity).setTitle("About")
                .setMessage("Created By Andrea Pallotta")
                .create()
    }
}