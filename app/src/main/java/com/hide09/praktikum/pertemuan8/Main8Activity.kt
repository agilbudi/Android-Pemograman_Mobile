package com.hide09.praktikum.pertemuan8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hide09.praktikum.R
import kotlinx.android.synthetic.main.activity_main8.*

class Main8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

        view_pager.adapter = ViewPagerAdapter(this, supportFragmentManager)
        tabs.setupWithViewPager(view_pager)
    }
}