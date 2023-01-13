package com.example.appmeudiario

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmeudiario.Domain.DiaryDomain
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var newNoteBtn: FloatingActionButton
    private var diaryList = mutableListOf<DiaryDomain>()
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerViewNotes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadAllDiaries()
        recyclerViewNotes()

        newNoteBtn = findViewById(R.id.new_note)
        newNoteBtn.setOnClickListener {
            val calendar = Calendar.getInstance()
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val year = calendar.get(Calendar.YEAR).toString()
            val diary = DiaryDomain("",
                "",
                "happy", day, month, year)
            diaryList.add(diary)
            adapter.notifyDataSetChanged()
            val intent = Intent(this, DiaryDescription::class.java)
            intent.putExtra("diary", diaryList[diaryList.size-1])
            startActivity(intent)
        }
    }

    private fun recyclerViewNotes() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerViewNotes = findViewById(R.id.notesRecyclerView)
        recyclerViewNotes.layoutManager = linearLayoutManager

        adapter = MyAdapter(diaryList)
        recyclerViewNotes.adapter = adapter

    }

    private fun loadAllDiaries() {
        val diary1 = DiaryDomain("Oi sou o titulo disso ta doido porra",
            "Eu sou a descrição porra ukkkkkkkkkk mas eh isso não tem como eh o trikas",
            "happy", "03", "Feb", "2023")

        val diary2 = DiaryDomain("O de cima eh Otario",
            "Troslei kkkkkkkjjjjjjjjjjjj",
            "happy", "19", "Dec", "2021")
        diaryList.add(diary1)
        diaryList.add(diary2)
    }



//    private fun noteClicked(note: Button){

//            note.setOnClickListener {
//                val prefix = "note"
//                for (count in 1..layout.childCount) {
//                    val num = count.toString().padStart(2, '0')
//                    val tagName = "$prefix$num"
//
//                    when (note.getTag(R.id.note_btn)) {
//
//                        tagName -> {
//                            println("reconheceu o click")
//                            note.setText("Opa, voce clicou em mim, na $tagName")
//                        }
//                    }
//                }
//            }

//    }


}
