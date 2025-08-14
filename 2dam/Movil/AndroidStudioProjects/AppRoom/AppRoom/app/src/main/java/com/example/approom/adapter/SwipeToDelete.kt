package com.example.approom.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.approom.ui.HomeFragment

class SwipeToDelete(val adapter: ContactAdapter, val fragment: HomeFragment): ItemTouchHelper.SimpleCallback(0,
    ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        //coger la posicion
        val position = viewHolder.adapterPosition
        //realizar las operaciones
       // adapter.delete(position) lo dejo aqui o en el fragment
        fragment.deleteContact(position)

    }

}