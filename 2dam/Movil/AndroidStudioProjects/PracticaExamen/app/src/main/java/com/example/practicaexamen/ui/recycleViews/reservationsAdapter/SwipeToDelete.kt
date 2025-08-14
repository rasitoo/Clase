package com.example.practicaexamen.ui.recycleViews.reservationsAdapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaexamen.ui.ReservationsFragment

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
class SwipeToDelete (val adapter: ReservationsAdapter, val fragment: ReservationsFragment): ItemTouchHelper.SimpleCallback(0,
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
        fragment.deleteProd(position)

    }
}
