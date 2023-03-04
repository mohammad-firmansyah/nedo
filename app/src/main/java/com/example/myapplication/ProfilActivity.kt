package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_profil)

        val back : ImageView = findViewById(R.id.imgBack)
        val profil: ImageView = findViewById(R.id.about_page)

        profil.setOnClickListener{
            startActivity(Intent(this,ProfilActivity::class.java))
        }

        back.setOnClickListener{
            finish()
        }
    }
}