package com.example.approom.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.approom.R
import com.example.approom.databinding.ItemContactBinding
import com.example.approom.db.Contact

class ContactAdapter( var contactList:MutableList<Contact>,
   var listener: OnClikContact )
    :RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private lateinit var mContext : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datoItem = contactList[position]

        holder.bind(datoItem)
        holder.setListener(datoItem)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    //Actualizar la lista
    fun setDato(datos: List<Contact>){
        this.contactList = datos.toMutableList()
        notifyDataSetChanged()
    }

    //borrar elemento de la lista
    fun delete(position: Int) {
        contactList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val binding = ItemContactBinding.bind(view)

        fun bind(contact: Contact) {
            binding.textViewName.text = contact.name
            binding.textViewPhone.text = contact.phone

            //cargar la imagen con Glide
            Glide.with(mContext)
                .load(Uri.parse(contact.image))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ico_access_time_24) //error
                .error(R.drawable.ico_broken_image_24)  //error a cargar la imagen
                .centerCrop()
                .into(binding.imageViewPhoto)
        }

        fun setListener(contact: Contact) {
            binding.root.setOnClickListener { listener.onclickElem(contact.id) }
        }

    }
}