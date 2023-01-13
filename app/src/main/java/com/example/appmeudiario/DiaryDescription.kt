package com.example.appmeudiario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.appmeudiario.Domain.DiaryDomain
import java.io.Serializable

class DiaryDescription : AppCompatActivity(), Serializable {
    private lateinit var saveButton: TextView
    private lateinit var titleText: EditText
    private lateinit var descriptionText: EditText
    private lateinit var day: TextView
    private lateinit var month: TextView
    private lateinit var year: TextView
    private lateinit var fontSize: ImageView
    private lateinit var listItemMarker: ImageView
    private lateinit var gallery: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_description)

        initView()
        //getBundle()
        initDiary()


    }

    private fun initView(){
        saveButton = findViewById(R.id.save_diary_btn)
        titleText = findViewById(R.id.title)
        descriptionText = findViewById(R.id.description)
        day = findViewById(R.id.day)
        month = findViewById(R.id.month)
        year = findViewById(R.id.year)
        gallery = findViewById(R.id.gallery)
        fontSize = findViewById(R.id.fontSize)
        listItemMarker = findViewById(R.id.markerList)


    }

    private fun initDiary(){
        val diary = intent.getParcelableExtra<DiaryDomain>("diary")
        if (diary != null) {
            if (!titleText.text.equals(""))
                titleText.setText(diary.getTitle())
            if (!descriptionText.text.equals(""))
                descriptionText.setText(diary.getDescription())
            day.text = diary.getDay()
            month.text = diary.getMonth()
            year.text = diary.getYear()
        }

        saveButton.setOnClickListener{
            if (diary != null) {
                diary.setTitle(titleText.text.toString())
                diary.setDescription(descriptionText.text.toString())
                println("ushdus")
            }
        }
    }
}
























