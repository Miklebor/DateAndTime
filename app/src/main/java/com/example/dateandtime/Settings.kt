package com.example.dateandtime

import android.app.ActionBar.LayoutParams
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView

class Settings : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        showEditTextDialog()
    }

    fun showEditTextDialog() {
        val button_1 = findViewById<TextView>(R.id.textView8)
        val button_2 = findViewById<TextView>(R.id.textView9)
        button_1.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            val inflater: LayoutInflater = layoutInflater
            val dialogLayout: View = inflater.inflate(R.layout.edit_event_layout, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.et_EditText)

                with(builder) {
                    setTitle("Назовите событие")
                    setPositiveButton("OK") { dialog, which ->
                        button_1.text = editText.text.toString()
                    }
                    setNegativeButton("Cancel") { dialog, which ->
                        Log.d("Main", "Была нажата кнопка Отмена")
                    }
                    setView(dialogLayout)
                    show()
                    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
                }
            }
        button_2.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            val inflater: LayoutInflater = layoutInflater
            val dialogLayout: View = inflater.inflate(R.layout.edit_event_layout, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.et_EditText)

            with(builder) {
                setTitle("Назовите событие")
                setPositiveButton("OK") { dialog, which ->
                    button_2.text = editText.text.toString()
                }
                setNegativeButton("Cancel") { dialog, which ->
                    Log.d("Main", "Была нажата кнопка Отмена")
                }
                setView(dialogLayout)
                show()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
            }
        }
    }

}
