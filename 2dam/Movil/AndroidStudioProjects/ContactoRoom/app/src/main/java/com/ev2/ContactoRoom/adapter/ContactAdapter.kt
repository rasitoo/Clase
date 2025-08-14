package com.ev2.ContactoRoom.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ev2.ContactoRoom.App
import com.ev2.ContactoRoom.R
import com.ev2.ContactoRoom.databinding.ItemContactBinding
import com.ev2.ContactoRoom.db.Contact
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class ContactAdapter(
    var contactlist: MutableList<Contact>,
    private var listener: OnListenerContact
) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {


    private lateinit var mContext: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactAdapter.ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactlist.size
    }


    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {

        val datoItem = contactlist[position]


        holder.bind(datoItem)
        holder.setListener(datoItem)
    }

    fun setDato(datoList: List<Contact>) {
        this.contactlist = datoList.toMutableList()
        notifyDataSetChanged()
    }

    fun delete(position: Int) {

        contactlist.removeAt(position)
        notifyItemRemoved(position)

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemContactBinding.bind(view)

        fun bind(contact: Contact) {
            binding.textNom.text = contact.name
            binding.textNum.text = contact.phone

            Glide.with(mContext)
                .load(Uri.parse(contact.image))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ico_access_time_24)
                .error(R.drawable.ico_broken_image_24)
                .centerCrop()
                .into(binding.imageView)
        }

        fun setListener(contact: Contact) {
            binding.root.setOnClickListener { listener.onClick() }
        }
    }
}