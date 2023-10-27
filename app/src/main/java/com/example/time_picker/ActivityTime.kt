package com.example.time_picker

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.time_picker.databinding.ActivityTimeBinding

class ActivityTime : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityTimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTimePicker.setOnClickListener(this)
    }

    // Funcão que irá verificar/manuzear os parametros
    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_time_picker -> {
                TimePickerDialog(this, this, 20, 15, true).show()
            }
        }
    }

    // Observando os valores setados e mostrando em tela os respectivos valores
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        binding.textTimePicker.text = "$hourOfDay:$minute"
    }
}