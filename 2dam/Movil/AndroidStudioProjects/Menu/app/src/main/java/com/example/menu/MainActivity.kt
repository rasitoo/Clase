package com.example.menu

import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import com.example.menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var actionMode: ActionMode? = null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        registerForContextMenu(findViewById<ImageView>(R.id.imageView))

        val imageMenu = findViewById<ImageView>(R.id.imageView3)
        imageMenu.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.menuInflater.inflate(
                R.menu.menu_popup,
                popupMenu.menu
            )
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.option_copy -> {
                        Toast.makeText(
                            this, "Opción copy seleccionada",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }

                    R.id.option_share -> {
                        Toast.makeText(
                            this, "Opción share seleccionada",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }

                    R.id.option_download -> {
                        Toast.makeText(
                            this, "Opción download seleccionada",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }

                    else -> false
                }
            }
            popupMenu.show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.control_add -> {
                Toast.makeText(this, "opcion seleccionada ${R.id.control_add}", Toast.LENGTH_LONG)
                    .show()
                true
            }

            R.id.control_list -> {
                Toast.makeText(this, "opcion seleccionada ${R.id.control_list}", Toast.LENGTH_LONG)
                    .show()
                true
            }

            R.id.control_delete -> {
                Toast.makeText(
                    this,
                    "opcion seleccionada ${R.id.control_delete}",
                    Toast.LENGTH_LONG
                ).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_flotante, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_copy -> {
                Toast.makeText(this, "opcion seleccionada ${R.id.option_copy}", Toast.LENGTH_LONG)
                    .show()
                true
            }

            R.id.option_share -> {
                Toast.makeText(this, "opcion seleccionada ${R.id.option_share}", Toast.LENGTH_LONG)
                    .show()
                true
            }

            R.id.option_download -> {
                Toast.makeText(
                    this,
                    "opcion seleccionada ${R.id.option_download}",
                    Toast.LENGTH_LONG
                ).show()
                true
            }

            else -> super.onContextItemSelected(item)
        }

    }

}



