package com.example.practicaestadointentdialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar


class TimePickerFragment : DialogFragment(),
    TimePickerDialog.OnTimeSetListener {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)


        return TimePickerDialog(
            activity, this, hour, minute,
            DateFormat.is24HourFormat(activity)
        )
    }

    override fun onTimeSet(
        view: TimePicker?, hourOfDay: Int,
        minute: Int
    ) {
        // Llamar a la interfaz para pasar los valores seleccionados a la actividad
        val listener = activity as? OnTimeSelectedListener
        listener?.onTimeSelected(hourOfDay, minute)
    }

    // Interfaz para el callback
    interface OnTimeSelectedListener {
        fun onTimeSelected(hourOfDay: Int, minute: Int)
    }

}