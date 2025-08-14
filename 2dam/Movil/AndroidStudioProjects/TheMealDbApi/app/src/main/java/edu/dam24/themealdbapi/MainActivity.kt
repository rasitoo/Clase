package edu.dam24.themealdbapi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import edu.dam24.themealdbapi.adapter.CategoryAdapter
import edu.dam24.themealdbapi.databinding.ActivityMainBinding

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

        binding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(this@MainActivity,2)
        }

        viewModel.state.observe(this, Observer {state->
            binding.progress.visibility = if (state.loading) View.VISIBLE else View.GONE
            if (state.list != null){
                mAdapter.listCategory = state.list
                mAdapter.notifyDataSetChanged()
            }
            if(state.error != null){
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
            }
        })
    }
}