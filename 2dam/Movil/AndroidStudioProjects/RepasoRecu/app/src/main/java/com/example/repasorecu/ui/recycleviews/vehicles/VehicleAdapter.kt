package com.example.repasorecu.ui.recycleviews.vehicles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.repasorecu.R
import com.example.repasorecu.databinding.ItemVehicleBinding
import com.example.repasorecu.models.Vehicle

/**
 * @author Rodrigo
 * @date 13 marzo, 2025
 */
class VehicleAdapter (var personalList: MutableList<Vehicle>) :
    RecyclerView.Adapter<VehicleAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_vehicle, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleAdapter.ViewHolder, position: Int) {
        val item = personalList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return personalList.size
    }

    fun addVehicle(vehicle: Vehicle) {
        personalList.add(vehicle)
        notifyDataSetChanged()
    }
    fun setDato(datos: List<Vehicle>){
        this.personalList = datos.toMutableList()
        notifyDataSetChanged()
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemVehicleBinding.bind(view)

        fun bind(vehicle: Vehicle) {
            binding.textViewFecha.text = vehicle.entryDate
            binding.textViewMatricula.text = vehicle.matricula
            binding.textViewTipo.text = vehicle.type
            binding.textViewEntrada.text = vehicle.state

            when (vehicle.priority) {
                1 -> {
                    binding.imageView.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.color1_700
                        )
                    )
                }
                2 -> {
                    binding.imageView.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.color2_700
                        )
                    )
                }
                3 -> {
                    binding.imageView.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.color4_700
                        )
                    )
                }
            }
        }
    }
}