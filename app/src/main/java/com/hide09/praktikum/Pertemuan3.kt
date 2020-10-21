package com.hide09.praktikum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hide09.praktikum.pertemuan3.ConstrainLayout
import com.hide09.praktikum.pertemuan3.LatihanConstraintLayout
import com.hide09.praktikum.pertemuan3.LatihanLinearLayout
import com.hide09.praktikum.pertemuan3.LinearLayout
import kotlinx.android.synthetic.main.activity_pertemuan3.*

class Pertemuan3 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertemuan3)

        btn_linear.setOnClickListener(this)
        btn_constraint.setOnClickListener(this)
        btn_lat_Linear.setOnClickListener(this)
        btn_lat_Constraint.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btn_linear->{
                val intent = Intent(this, LinearLayout::class.java)
                startActivity(intent)
            }
            R.id.btn_constraint->{
                val intent = Intent(this, ConstrainLayout::class.java)
                startActivity(intent)
            }
            R.id.btn_lat_Linear->{
                val intent = Intent(this, LatihanLinearLayout::class.java)
                startActivity(intent)
            }
            R.id.btn_lat_Constraint->{
                val intent = Intent(this, LatihanConstraintLayout::class.java)
                startActivity(intent)
            }
        }
    }
}
