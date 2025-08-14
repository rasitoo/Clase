package com.example.approom.ui

import android.icu.text.Transliterator.Position
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.approom.App
import com.example.approom.R
import com.example.approom.adapter.ContactAdapter
import com.example.approom.adapter.OnClikContact
import com.example.approom.adapter.SwipeToDelete
import com.example.approom.databinding.FragmentHomeBinding
import com.example.approom.db.Contact
import kotlinx.coroutines.launch


class HomeFragment : Fragment(), OnClikContact {

    private lateinit var  binding: FragmentHomeBinding

    private lateinit var  mAdapter : ContactAdapter
    private lateinit var mLinearLayout : LinearLayoutManager

    private val viewmodel : HomeViewModel by viewModels{
        HomeViewModelFactory(App.db.contactDao())
    }

    private var datoList : List<Contact> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //boton para añadir registro
        binding.floatingActionButton.setOnClickListener { irAFragmentAdd() }
        //mostrar el recycler
        setupRecyclerview()

    }

    private fun setupRecyclerview() {
        mAdapter = ContactAdapter(mutableListOf(),this)
        mLinearLayout = LinearLayoutManager(requireContext())

        //cargar los datos

        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = mLinearLayout
            adapter = mAdapter
        }

        viewmodel.allContacts.observe(viewLifecycleOwner){contacts->
            mAdapter.setDato(contacts)
        }

        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(mAdapter, this))
        itemTouchHelper.attachToRecyclerView(binding.recyclerview)
    }



    private fun irAFragmentAdd() {
        val action = HomeFragmentDirections.actionHomeFragmentToAddFragment(-1)
        findNavController().navigate(action)
    }

    fun deleteContact(position: Int){
        val item = mAdapter.contactList[position] //contactList es la variable del adaptador
        mAdapter.delete(position)
        viewmodel.delete(item)

    }


    //miembro de la interface OnClick, encargado de mostrar el registro para editar
    override fun onclickElem(id: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToAddFragment(id)
        findNavController().navigate(action)
    }
}