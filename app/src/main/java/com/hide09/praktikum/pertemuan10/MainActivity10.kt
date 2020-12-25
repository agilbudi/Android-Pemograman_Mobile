package com.hide09.praktikum.pertemuan10

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hide09.praktikum.R
import com.hide09.praktikum.pertemuan10.catatan.Note
import kotlinx.android.synthetic.main.activity_main10.*

class MainActivity10 : AppCompatActivity() {
    companion object {
        const val ADD_NOTE_REQUEST = 1
        const val EDIT_NOTE_REQUEST = 2
    }
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        btn10_AddNote.setOnClickListener {
            startActivityForResult(
                Intent(this, AddNoteActivity10::class.java),
                ADD_NOTE_REQUEST
            )
        }

        rv10.layoutManager = LinearLayoutManager(this)
        rv10.setHasFixedSize(true)

        val adapter = NoteAdapter()
        rv10.adapter = adapter

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        noteViewModel.getAllNotes().observe(this, Observer<List<Note>>{
            adapter.submitList(it)
        })

        ItemTouchHelper(object :
        ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT)){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                noteViewModel.delete(adapter.getNoteAt(viewHolder.adapterPosition))
                Toast.makeText(baseContext, "Catatan Dihapus!", Toast.LENGTH_SHORT).show()
            }
        }
        ).attachToRecyclerView(rv10)

        adapter.setOnItemClickListener(object : NoteAdapter.OnItemClickListener{
            override fun onItemClick(note: Note) {
                val intent = Intent(baseContext, AddNoteActivity10::class.java)
                intent.putExtra(AddNoteActivity10.EXTRA_ID, note.id)
                intent.putExtra(AddNoteActivity10.EXTRA_JUDUL, note.title)
                intent.putExtra(AddNoteActivity10.EXTRA_DESKRIPSI, note.description)
                intent.putExtra(AddNoteActivity10.EXTRA_PRIORITAS, note.priority)

                startActivityForResult(intent, EDIT_NOTE_REQUEST)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main10_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId){
            R.id.menu_delete_all_notes -> {
                noteViewModel.deleteAllNotes()
                Toast.makeText(this, "Semua sudah dihapus!", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK){
            val newNote = Note(
                data!!.getStringExtra(AddNoteActivity10.EXTRA_JUDUL).toString(),
                data.getStringExtra(AddNoteActivity10.EXTRA_DESKRIPSI).toString(),
                data.getIntExtra(AddNoteActivity10.EXTRA_PRIORITAS, 1)
            )
            noteViewModel.insert(newNote)
            Toast.makeText(this, "Catatan disimpan!", Toast.LENGTH_SHORT).show()
        }else if (requestCode == EDIT_NOTE_REQUEST && resultCode == Activity.RESULT_OK){
            val id = data?.getIntExtra(AddNoteActivity10.EXTRA_ID, -1)
            if (id == -1){
                Toast.makeText(this, "Pembaharuan gagal!", Toast.LENGTH_SHORT).show()
            }
            val updateNote = Note(
                data!!.getStringExtra(AddNoteActivity10.EXTRA_JUDUL).toString(),
                data.getStringExtra(AddNoteActivity10.EXTRA_DESKRIPSI).toString(),
                data.getIntExtra(AddNoteActivity10.EXTRA_PRIORITAS, 1)
            )
            updateNote.id = data.getIntExtra(AddNoteActivity10.EXTRA_ID, -1)
            noteViewModel.update(updateNote)
        }else{
            Toast.makeText(this, "Catatan tidak disimpan!", Toast.LENGTH_SHORT).show()
        }
    }
}