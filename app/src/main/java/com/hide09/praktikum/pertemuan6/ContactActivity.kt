package com.hide09.praktikum.pertemuan6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hide09.praktikum.R
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val testData = createPhoneData()
        rv_contact.layoutManager = LinearLayoutManager(this)
        rv_contact.setHasFixedSize(true)
        rv_contact.adapter = ContactAdapter(testData, { phoneItem: PhoneData -> phoneItemClicked(phoneItem) })
    }

    private fun createPhoneData(): List<PhoneData> {
        val itemList = ArrayList<PhoneData>()
        itemList.add(PhoneData(6284845645566, "Alpha"))
        itemList.add(PhoneData(6284656544665, "Bravo"))
        itemList.add(PhoneData(6285465444445, "Delta"))
        itemList.add(PhoneData(6281896845645, "Charlie"))
        itemList.add(PhoneData(6283854855555, "Omega"))
        return itemList
    }

    private fun phoneItemClicked(phoneItem: PhoneData) {
        val showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        startActivity(showDetailActivityIntent)
    }
}