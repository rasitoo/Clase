package com.example.recuperacionrodrigotapiador.ui

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar
class DatePickerFragment(private val listener: (year: Int, month: Int, day: Int) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            listener(selectedYear, selectedMonth, selectedDay)
        }, year, month, day)
    }
}