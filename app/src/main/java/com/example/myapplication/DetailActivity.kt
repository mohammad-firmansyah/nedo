package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {
    lateinit var titleDetail : TextView
    lateinit var desc : TextView
    lateinit var kkal : TextView
    lateinit var category : TextView
    lateinit var heroimg : ImageView
    lateinit var rvBahan : RecyclerView
    lateinit var rvLangkah : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_detail)

        val back : ImageView = findViewById(R.id.imgBack)
        val profil: ImageView = findViewById(R.id.imgMenu)

        profil.setOnClickListener{
            startActivity(Intent(this,ProfilActivity::class.java))
        }

        back.setOnClickListener{
            finish()
        }


        titleDetail = findViewById(R.id.titleDetail)
        desc = findViewById(R.id.desc)
        kkal = findViewById(R.id.kkal)
        category = findViewById(R.id.category)
        heroimg = findViewById(R.id.heroimg)
        rvBahan = findViewById(R.id.bahan)
        rvLangkah = findViewById(R.id.langkah)

        val resep = intent.getParcelableExtra<Resep>("resep")
        if (resep != null) {
            titleDetail.setText(resep.name)
            desc.setText(resep.description)
            kkal.setText(resep.calOfAmount)
            category.setText(resep.category)
//            heroimg.setText(resep.category)
//            rvBahan.setText(resep.category)
        }
    }
}