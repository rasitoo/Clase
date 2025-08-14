package com.example.examenrodrigotapiador.ui.recycleViews.appointment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrodrigotapiador.R
import com.example.examenrodrigotapiador.databinding.ItemAppointmentBinding
import com.example.examenrodrigotapiador.models.Appointment
import com.example.examenrodrigotapiador.ui.recycleViews.OnClickElement

/**
 * @author Rodrigo
 * @date 21 febrero, 2025
 */
class AppointmentsAdapter(
    var appointmentsList: MutableList<Appointment>,
    var listener: OnClickElement
) : RecyclerView.Adapter<AppointmentsAdapter.ViewHolder>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_appointment, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return appointmentsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datoItem = appointmentsList[position]

        holder.bind(datoItem)
        holder.setListener(datoItem)
    }
    //Actualizar la lista
    fun setDato(datos: List<Appointment>){
        this.appointmentsList = datos.toMutableList()
        notifyDataSetChanged()
    }

    //borrar elemento de la lista
    fun delete(position: Int) {
        appointmentsList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemAppointmentBinding.bind(view)

        fun bind(appointment: Appointment) {
            binding.textViewHour.text = appointment.hora
            binding.textViewClass.text = appointment.aula
            binding.textViewProf.text = appointment.asignatura
        }

        fun setListener(appointment: Appointment) {
            binding.root.setOnClickListener { appointment.id?.let { it1 -> listener.onclickElem(it1) } }
        }
    }


}