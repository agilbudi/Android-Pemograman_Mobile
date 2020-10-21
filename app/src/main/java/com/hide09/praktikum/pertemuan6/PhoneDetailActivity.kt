package com.hide09.praktikum.pertemuan6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hide09.praktikum.R
import kotlinx.android.synthetic.main.activity_phone_detail.*

class PhoneDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_detail)

        var intentActivity = getIntent()

        if (intentActivity.hasExtra(Intent.EXTRA_TEXT)){
            var detaiId = intentActivity.getStringExtra(Intent.EXTRA_TEXT)
            tv_detail_item_id.text = detaiId
        }
    }
}