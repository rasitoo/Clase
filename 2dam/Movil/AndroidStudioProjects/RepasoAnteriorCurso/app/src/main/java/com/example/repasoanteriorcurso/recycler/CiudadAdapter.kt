package com.example.repasoanteriorcurso.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repasoanteriorcurso.R
import com.example.repasoanteriorcurso.databinding.ItemCiudadBinding
import com.example.repasoanteriorcurso.models.Registro

/**
 * @author Rodrigo
 * @date 12 marzo, 2025
 */
class CiudadAdapter(
    private var ciudades: MutableList<Registro>,
    val listener: CiudadOnClickListener
) : RecyclerView.Adapter<CiudadAdapter.ViewHolder>() {

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_ciudad, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datoItem = ciudades[position]

        holder.bind(datoItem)
        holder.setListener(datoItem)
    }

    override fun getItemCount(): Int {
        return ciudades.size
    }

    //Actualizar la lista
    fun setDato(datos: List<Registro>) {
        this.ciudades = datos.toMutableList()
        notifyDataSetChanged()
    }

    //borrar elemento de la lista
    fun delete(position: Int) {
        ciudades.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemCiudadBinding.bind(view)

        fun bind(ciudad: Registro) {
            binding.tvCiudad.text = ciudad.ciudad
            binding.tvVotosEmitidos.text = ciudad.votosEmitidos.toString()
            binding.tvVotosNulos.text = ciudad.votosNulos.toString()
            binding.tvVotosBlancos.text = ciudad.votosBlancos.toString()
//            Glide.with(mContext)
//                .load(category.strCategoryThumb)
//                .into(binding.imageMovie)

            // binding.imageFavorite.visibility = if(movie.favorite) View.VISIBLE else View.GONE
        }

        fun setListener(ciudad: Registro) {
            binding.root.setOnClickListener { listener.onClick(ciudad) }
        }
    }
}