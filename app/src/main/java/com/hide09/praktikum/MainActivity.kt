package com.hide09.praktikum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hide09.praktikum.pertemuan5.RecycleView
import com.hide09.praktikum.pertemuan6.ContactActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_prt3.setOnClickListener(this)
        btn_prt4.setOnClickListener(this)
        btn_prt5.setOnClickListener(this)
        btn_prt6.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id){
            R.id.btn_prt3->{
                val intent = Intent(this, Pertemuan3::class.java)
                startActivity(intent)
            }
            R.id.btn_prt4->{
                val intent = Intent(this, Pertemuan4::class.java)
                startActivity(intent)
            }
            R.id.btn_prt5->{
                val intent = Intent(this, RecycleView::class.java)
                startActivity(intent)
            }
            R.id.btn_prt6->{
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
            }
        }
    }
}