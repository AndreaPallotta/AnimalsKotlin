package com.pallotta.andrea.animals

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class InfoDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity).setTitle("Info")
            .setMessage("Learn the alphabet while also learning about animals")
            .create()
    }
}