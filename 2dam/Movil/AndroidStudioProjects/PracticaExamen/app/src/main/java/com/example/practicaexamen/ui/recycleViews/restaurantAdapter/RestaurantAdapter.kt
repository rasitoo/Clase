package com.example.practicaexamen.ui.recycleViews.restaurantAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaexamen.databinding.ItemDatoBinding
import com.example.practicaexamen.models.Restaurant
import com.example.practicaexamen.ui.recycleViews.DatoOnclickListener

class RestaurantAdapter(
    private var restaurants: List<Restaurant>,
    private val clickListener: DatoOnclickListener
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    private lateinit var mContext : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        mContext = parent.context
        val binding = ItemDatoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(restaurants[position], clickListener)
    }

    override fun getItemCount(): Int = restaurants.size

    fun updateRestaurants(newRestaurants: List<Restaurant>) {
        restaurants = newRestaurants
        notifyDataSetChanged()
    }



    class RestaurantViewHolder(private val binding: ItemDatoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: Restaurant, clickListener: DatoOnclickListener) {
            binding.textViewNombre.setText(restaurant.name)
            binding.imageView.setImageResource(restaurant.imageResId)
            binding.textViewTipo.setText(restaurant.category)
            binding.root.setOnClickListener { clickListener.onClickEdit(restaurant.id) }
        }

    }
}