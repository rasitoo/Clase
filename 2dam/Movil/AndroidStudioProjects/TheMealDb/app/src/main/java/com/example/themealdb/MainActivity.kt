package com.example.themealdb

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.themealdb.adapter.CategoryAdapter
import com.example.themealdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    lateinit var mAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = CategoryAdapter(mutableListOf(), {})

        binding.RecyclerNews.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(this@MainActivity,2)
        }
        viewModel.state.observe(this, Observer { state ->
            binding.progress.visibility = if (state.loading) View.VISIBLE else View.GONE
            if (state.list != null){
                mAdapter.listCategory = state.list
                mAdapter.notifyDataSetChanged()
            }
        })
    }
}