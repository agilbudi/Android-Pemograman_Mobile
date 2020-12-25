package com.hide09.praktikum.pertemuan10

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.hide09.praktikum.R
import kotlinx.android.synthetic.main.activity_add_note10.*

class AddNoteActivity10 : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "com.hide09.praktikum.pertemuan10.EXTRA_ID"
        const val EXTRA_JUDUL = "com.hide09.praktikum.pertemuan10.EXTRA_JUDUL"
        const val EXTRA_DESKRIPSI = "com.hide09.praktikum.pertemuan10.EXTRA_DESKRIPSI"
        const val EXTRA_PRIORITAS = "com.hide09.praktikum.pertemuan10.EXTRA_PRIORITAS"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note10)

        number_picker_priority.minValue = 1
        number_picker_priority.maxValue = 5

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_black_24)
        if (intent.hasExtra(EXTRA_ID)){
            title = "Edit Catatan"
            et10_title.setText(intent.getStringExtra(EXTRA_JUDUL))
            et10_description.setText(intent.getStringExtra(EXTRA_DESKRIPSI))
            number_picker_priority.value = intent.getIntExtra(EXTRA_PRIORITAS, 1)
        }else{
            title = "Tambah Catatan"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add10_note_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId){
            R.id.save_note -> {
                saveNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveNote() {
        if (et10_title.text.toString().trim().isBlank() || et10_description.text.toString().trim().isBlank()){
            Toast.makeText(this, "Catatan Kosong!", Toast.LENGTH_SHORT).show()
            return
        }

        val data = Intent().apply {
            putExtra(EXTRA_JUDUL, et10_title.text.toString())
            putExtra(EXTRA_DESKRIPSI, et10_description.text.toString())
            putExtra(EXTRA_PRIORITAS, number_picker_priority.value)
            if (intent.getIntExtra(EXTRA_ID, -1) != -1){
                putExtra(EXTRA_ID, intent.getIntExtra(EXTRA_ID, -1))
            }
        }
        setResult(Activity.RESULT_OK, data)
        finish()
    }
}