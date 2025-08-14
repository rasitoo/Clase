package com.example.practicaestadointentdialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar


class DatePicker : DialogFragment(), OnDateSetListener {
    interface OnDateSetListener {
        fun onDateSet(
            view: DatePicker?, year: Int, month: Int, day:
            Int
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?):
            Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            requireContext(), this, year, month, day
        )

    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val listener = activity as? OnDateSetListener
        listener?.onDateSet(view, year, month, day)
    }


}
