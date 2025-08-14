package com.example.practicaexamen.ui.recycleViews.reservationsAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaexamen.R
import com.example.practicaexamen.databinding.ItemReservationBinding
import com.example.practicaexamen.models.Reservation
import com.example.practicaexamen.ui.recycleViews.DatoOnclickListener

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
class ReservationsAdapter(var reservationsList: MutableList<Reservation>, var listener: DatoOnclickListener) : RecyclerView.Adapter<ReservationsAdapter.ViewHolder>(){

    private lateinit var mContext : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_reservation, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val datoItem = reservationsList[position]

        holder.bind(datoItem)
        holder.setListener(datoItem)
    }

    override fun getItemCount(): Int {
        return reservationsList.size
    }

    //Actualizar la lista
    fun setDato(datos: List<Reservation>){
        this.reservationsList = datos.toMutableList()
        notifyDataSetChanged()
    }

    //borrar elemento de la lista
    fun delete(position: Int) {
        reservationsList.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val binding = ItemReservationBinding.bind(view)

        fun bind(reservation: Reservation){
            binding.TextViewNombreProd.text = reservation.date
//            Glide.with(mContext)
//                .load(category.strCategoryThumb)
//                .into(binding.imageMovie)

            // binding.imageFavorite.visibility = if(movie.favorite) View.VISIBLE else View.GONE
        }

        fun setListener(reservation: Reservation) {
            binding.root.setOnClickListener { listener.onClickEdit(reservation.id) }
        }
    }
}