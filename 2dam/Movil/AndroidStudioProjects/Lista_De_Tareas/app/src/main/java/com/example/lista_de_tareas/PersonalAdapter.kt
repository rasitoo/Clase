package com.example.lista_de_tareas

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_de_tareas.databinding.ItemTareaBinding

/**
 * @author Rodrigo
 * @date 15 noviembre, 2024
 */
class PersonalAdapter(var personalList: MutableList<NotaPersonal>) :
    RecyclerView.Adapter<PersonalAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_tarea, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonalAdapter.ViewHolder, position: Int) {
        val item = personalList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return personalList.size
    }

    fun addNotaPerson(notaPersonal: NotaPersonal) {
        personalList.add(notaPersonal)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemTareaBinding.bind(view)

        fun bind(notaPersonal: NotaPersonal) {
            binding.textViewFecha.text = notaPersonal.fecha
            binding.textViewNota.text = notaPersonal.descripcion

            when (notaPersonal.categoria) {
                "Personal" -> {
                    binding.imageView.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.color1_700
                        )
                    )
                }
                "Trabajo" -> {
                    binding.imageView.setBackgroundColor(
                        ContextCompat.getColor(
                            mContext,
                            R.color.color2_700
                        )
                    )
                }
                "Urgente" -> {
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