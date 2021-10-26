package com.poohxx.kotlinfishermanhandbook

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        var tvTitle1 = findViewById<TextView>(R.id.tvTitle1)
        var tvContent1 = findViewById<TextView>(R.id.tvContent1)
        var im1 = findViewById<ImageView>(R.id.im1)

        tvTitle1.text = intent.getStringExtra("title")
        tvContent1.text = intent.getStringExtra("content")
        im1.setImageResource(intent.getIntExtra("image",R.drawable.shuca))

    }

}