package com.example.practicaexamen.ui.recycleViews.categoryAdapter

/**
 * @author Rodrigo
 * @date 20 febrero, 2025
 */
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicaexamen.R
import com.example.practicaexamen.databinding.ItemCategoryBinding
import com.example.practicaexamen.models.Category

class CategoryAdapter(var listCategory: List<Category>, private val listener: (Category) -> Unit,) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    //, private val listener: (Movie)-> Unit
    // private var listMovie:List<Movie> = mutableListOf()
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listCategory[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int {
        return listCategory.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val binding = ItemCategoryBinding.bind(view)

        fun bind(category: Category){
            binding.textTitle.text = category.strCategory
            Glide.with(mContext)
                .load(category.strCategoryThumb)
                .into(binding.imageMovie)

            // binding.imageFavorite.visibility = if(movie.favorite) View.VISIBLE else View.GONE
        }

    }
}