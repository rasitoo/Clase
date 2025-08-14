package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycler.databinding.ItemDatoBinding

/**
 * @author Rodrigo
 * @date 08 noviembre, 2024
 */
class UserAdapter(private val listDato: List<DatoUser>, private val listener: DatoOnclickListener) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    //implementar los metodos del adaptador
    //inflar el el recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dato, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
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
        fun bind(datoUser: DatoUser) {
            binding.textViewElemento.text = datoUser.name
            //trabajar con la imagen
            Glide.with(binding.imageView)
                .load(datoUser.imagen)
                .into(binding.imageView)
        }

        //trabajar los listener
        fun setListener(item: DatoUser) {
            binding.root.setOnClickListener { listener.onClickEdit(item) }
        }
    }
}