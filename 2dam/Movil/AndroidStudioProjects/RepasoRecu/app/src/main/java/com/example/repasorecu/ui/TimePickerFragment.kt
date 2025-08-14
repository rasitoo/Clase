package com.example.examenrodrigotapiador.ui


import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle

import androidx.fragment.app.DialogFragment
import java.util.Calendar
class TimePickerFragment(private val listener: (hourOfDay: Int, minute: Int) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener { _, selectedHour: Int, selectedMinute: Int ->
            listener(selectedHour, selectedMinute)
        }, hour, minute, true)
    }
}