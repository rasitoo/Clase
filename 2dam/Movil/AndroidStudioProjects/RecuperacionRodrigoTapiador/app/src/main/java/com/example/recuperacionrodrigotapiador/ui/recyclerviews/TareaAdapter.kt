package com.example.recuperacionrodrigotapiador.ui.recyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.recuperacionrodrigotapiador.R
import com.example.recuperacionrodrigotapiador.databinding.ItemTareaBinding
import com.example.recuperacionrodrigotapiador.models.Tarea

/**
 * @author Rodrigo
 * @date 14 marzo, 2025
 */
class TareaAdapter(var personalList: MutableList<Tarea>) :
    RecyclerView.Adapter<TareaAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_tarea, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareaAdapter.ViewHolder, position: Int) {
        val item = personalList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return personalList.size
    }

    fun addTarea(tarea: Tarea) {
        personalList.add(tarea)
        notifyDataSetChanged()
    }

    fun setDato(datos: List<Tarea>) {
        this.personalList = datos.toMutableList()
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemTareaBinding.bind(view)

        fun bind(tarea: Tarea) {
            binding.textViewElemento.text = tarea.title

            when (tarea.state) {
                "2131231286" -> {
                    binding.imageView2.setImageResource(R.drawable.baseline_pending_24)
                }

                "2131231287" -> {
                    binding.imageView2.setImageResource(R.drawable.baseline_border_color_24)
                }

                "2131231282" -> {
                    binding.imageView2.setImageResource(R.drawable.baseline_done_all_24)
                }
            }
        }
    }
}
