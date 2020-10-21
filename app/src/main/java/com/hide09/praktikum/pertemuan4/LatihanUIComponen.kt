package com.hide09.praktikum.pertemuan4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.hide09.praktikum.R

class LatihanUIComponen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_u_i_componen)
        val imgBtnPlus = findViewById<ImageButton>(R.id.imageButtonLat)
        val imgBtnX = findViewById<ImageButton>(R.id.imageButton2Lat)
        imgBtnPlus.setOnClickListener {
            Toast.makeText(this, "Berhasil ditambah...", Toast.LENGTH_SHORT).show()
        }
        imgBtnX.setOnClickListener {
            Toast.makeText(this, "Berhasil dihapus...", Toast.LENGTH_SHORT).show()
        }
    }
}