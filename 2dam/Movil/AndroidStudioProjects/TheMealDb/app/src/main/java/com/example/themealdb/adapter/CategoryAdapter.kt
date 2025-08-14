package com.example.themealdb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themealdb.R
import com.example.themealdb.databinding.ItemCategoryBinding
import com.example.themealdb.model.server.CategoryX

/**
 * @author Rodrigo
 * @date 31 enero, 2025
 */
class CategoryAdapter(var listCategory: List<CategoryX>, private val listener: (CategoryX) -> Unit,) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    private lateinit var mContext: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val item = listCategory[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{listener(item)}
    }

    override fun getItemCount(): Int {
        return listCategory.size
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private  val binding = ItemCategoryBinding.bind(view)

        fun bind(category: CategoryX){
            binding.textTitle.text = category.strCategory
            Glide.with(mContext)
                .load(category.strCategoryThumb)
                .into(binding.imageView)
        }

    }

}