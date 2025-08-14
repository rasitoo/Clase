package com.ev2.ContactoRoom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.ev2.ContactoRoom.App
import com.ev2.ContactoRoom.R
import com.ev2.ContactoRoom.adapter.ContactAdapter
import com.ev2.ContactoRoom.adapter.OnListenerContact
import com.ev2.ContactoRoom.adapter.SwipeToDelete
import com.ev2.ContactoRoom.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch


class HomeFragment : Fragment(), OnListenerContact {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var mAdapter : ContactAdapter
    private lateinit var mLinearLayout: LinearLayoutManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Boton par añadir registro
        //mostrar el recycler
        //consultar la base de datos para generar la lista
        binding.btnAnadir.setOnClickListener{irAFragmentAdd()}
    }
    private fun irAFragmentAdd(){
        val action = HomeFragmentDirections.actionHomeFragmentToAddFragment(-1)
        findNavController().navigate(action)
    }


    private fun getAll() {
        lifecycleScope.launch {
            val datoList = App.db.contactDao().getAll()
            mAdapter.setDato(datoList)
            //val mAdapter=
        }
    }

    override fun onClick() {
        TODO("Not yet implemented")
    }

    override fun deleteContact(position: Int) {
        if (position >= 0 && position < mAdapter.contactlist.size) {
            val contact = mAdapter.contactlist[position]
            mAdapter.delete(position)
            lifecycleScope.launch {
                App.db.contactDao().delete(contact)
            }
        }


    }

    private fun setupRecyclerView(){
        mAdapter = ContactAdapter(mutableListOf(), this)
        mLinearLayout = LinearLayoutManager(requireContext())

        getAll()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayout
            adapter = mAdapter
        }
        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(mAdapter, this))
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }
}