package com.example.appmeudiario

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.appmeudiario.Domain.DiaryDomain

class MyAdapter(private val diaries: List<DiaryDomain>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_page, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentDiary = diaries[position]
        holder.bind(currentDiary)

        holder.note_layout.setOnClickListener {
            val intent = Intent(holder.itemView.context,  DiaryDescription::class.java)
            intent.putExtra("diary", currentDiary)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return diaries.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val note_layout: ConstraintLayout = itemView.findViewById(R.id.btn_layout)
        val day: TextView = itemView.findViewById(R.id.day)
        val month: TextView = itemView.findViewById(R.id.month)
        val title_text_view: TextView = itemView.findViewById(R.id.title)
        val description_text_view: TextView = itemView.findViewById(R.id.description)

        fun bind(currentDiary: DiaryDomain) {
            title_text_view.text = currentDiary.getTitle()
            day.text = currentDiary.getDay()
            month.text = currentDiary.getMonth()
            description_text_view.text = currentDiary.getDescription()
        }
    }
}
