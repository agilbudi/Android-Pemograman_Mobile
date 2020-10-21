package com.hide09.praktikum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hide09.praktikum.pertemuan4.LatihanUIComponen
import com.hide09.praktikum.pertemuan4.UIComponent
import kotlinx.android.synthetic.main.activity_pertemuan4.*

class Pertemuan4 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertemuan4)

        btn_ui.setOnClickListener(this)
        btn_lat_ui.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id){
            R.id.btn_ui->{
                val intent = Intent(this, UIComponent::class.java)
                startActivity(intent)
            }
            R.id.btn_lat_ui->{
                val intent = Intent(this, LatihanUIComponen::class.java)
                startActivity(intent)
            }
        }
    }
}