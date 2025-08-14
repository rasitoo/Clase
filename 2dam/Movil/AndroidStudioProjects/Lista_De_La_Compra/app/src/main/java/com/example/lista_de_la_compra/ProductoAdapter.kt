package com.example.lista_de_la_compra

/**
 * @author Rodrigo
 * @date 11 noviembre, 2024
 */
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_de_la_compra.databinding.ItemProductoBinding


class ProductoAdapter(
    var productoList: MutableList<Producto>,
    var listener: ProductoOnClickListener
) : RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return productoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = productoList[position]
        holder.bind(item)
        holder.setListener(item)


    }

    fun addProducto(producto: Producto) {
        productoList.add(producto)
        notifyDataSetChanged()
    }

    fun deleteProducto(producto: Producto) {
        productoList.remove(producto)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemProductoBinding.bind(view)

        fun bind(producto: Producto) {
            binding.textViewElemento.text = producto.elemento
        }
        //Trabajar los listener


        fun setListener(producto: Producto) {
            binding.root.setOnClickListener {
                listener.OnClickDelete(producto)
            }
        }


    }

}