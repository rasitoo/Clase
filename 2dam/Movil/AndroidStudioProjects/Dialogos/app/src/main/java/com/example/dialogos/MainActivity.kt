package com.example.dialogos

import android.R
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        // setup the alert builder
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Choose an animal")
//
//        // add a list
//        val animals = arrayOf("horse", "cow", "camel", "sheep", "goat")
//        builder.setItems(animals) { dialog, which ->
//            when (which) {
//                0 -> { /* horse */
//                }
//
//                1 -> { /* cow   */
//                }
//
//                2 -> { /* camel */
//                }
//
//                3 -> { /* sheep */
//                }
//
//                4 -> { /* goat  */
//                }
//            }
//        }
//
//        // create and show the alert dialog
//        val dialog = builder.create()
//        dialog.show()
//        // setup the alert builder
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Choose an animal")
//
//        // add a radio button list
//        val animals = arrayOf("horse", "cow", "camel", "sheep", "goat")
//        val checkedItem = 1 // cow
//        builder.setSingleChoiceItems(animals, checkedItem) { dialog, which ->
//            // user checked an item
//        }
//
//
//        // add OK and Cancel buttons
//        builder.setPositiveButton("OK") { dialog, which ->
//            // user clicked OK
//        }
//        builder.setNegativeButton("Cancel", null)
//
//        // create and show the alert dialog
//        val dialog = builder.create()
//        dialog.show()
//        // setup the alert builder
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Choose some animals")
//
//        // add a checkbox list
//        val animals = arrayOf("horse", "cow", "camel", "sheep", "goat")
//        val checkedItems = booleanArrayOf(true, false, false, true, false)
//        builder.setMultiChoiceItems(animals, checkedItems) { dialog, which, isChecked ->
//            // user checked or unchecked a box
//        }
//
//        // add OK and Cancel buttons
//        builder.setPositiveButton("OK") { dialog, which ->
//            // user clicked OK
//        }
//        builder.setNegativeButton("Cancel", null)
//
//        // create and show the alert dialog
//        val dialog = builder.create()
//        dialog.show()
//
//        // create an alert builder
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Name")
//
//        // add a button
//        builder.setPositiveButton("OK") { dialog, which -> // send data from the AlertDialog to the Activity
//            val editText = binding.
//            sendDialogDataToActivity(editText.text.toString())
//        }
//
//
//        // create and show the alert dialog
//        val dialog = builder.create()
//        dialog.show()
    }

    private fun sendDialogDataToActivity(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }
}