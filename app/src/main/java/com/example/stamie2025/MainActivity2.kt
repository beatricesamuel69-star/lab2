package com.example.stamie2025

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val stamie2025 =findViewById<ImageView>(R.id.imageView)
        val save =findViewById<ImageView>(R.id.imageView3)
        val question=findViewById<EditText>(R.id.editTextText)
        val answer=findViewById<EditText>(R.id.editTextText2)
        stamie2025.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        save.setOnClickListener {
            val chant1=question.text.toString()
            val chant2=answer.text.toString()
            val data= Intent().apply {
                 putExtra("question-key",chant1)
                putExtra("answer-key",chant2)



            }
            setResult(RESULT_OK,data)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}