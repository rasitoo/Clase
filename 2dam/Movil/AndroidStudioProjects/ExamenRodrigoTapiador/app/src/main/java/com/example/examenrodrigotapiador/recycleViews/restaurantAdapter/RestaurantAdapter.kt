package com.example.examenrodrigotapiador.recycleViews.restaurantAdapter;

/**
 * @author Rodrigo
 * @date 19 febrero, 2025
 */

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrodrigotapiador.DatoOnClickListener
import com.example.examenrodrigotapiador.models.Restaurant
import com.example.examenrodrigotapiador.R
import com.example.examenrodrigotapiador.databinding.ItemDatoBinding

class RestauranteAdapter(
    private val listDato: List<Restaurant>,
    private val listener: DatoOnclickListener
) :
    RecyclerView.Adapter<RestauranteAdapter.ViewHolder>() {
    //implementar los metodos del adaptador
//inflar el el recyclerview
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dato, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //recoge un elemento de la lista
        val item = listDato[position]
        //llamar el viewholder para mostrar el contenido del dato
        holder.bind(item)
        holder.setListener(item)
    }

    override fun getItemCount(): Int {
        //cuenta los elementos a mostrar
        return listDato.size
    }

    //clase interna
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //inflar el layout
        private val binding = ItemDatoBinding.bind(view)

        //recoger los datos del objeto y mostrarlos en el recyclerview
        fun bind(datoUser: Restaurant) {
            binding.textViewNombre.text = datoUser.name
            binding.textViewTipo.text = datoUser.categoria
            //trabajar con la imagen
            val resid = itemView.context.resources.getIdentifier(
                "restaurante_${datoUser.categoria}",
                "drawable",
                itemView.context.packageName
            )
            binding.imageView.setImageResource(resid)
        }

        //trabajar los listener
        fun setListener(item: Restaurant) {
            binding.root.setOnClickListener { listener.onClickEdit(item) }
        }
    }
}