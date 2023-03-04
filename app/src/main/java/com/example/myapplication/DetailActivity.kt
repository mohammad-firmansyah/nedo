package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    lateinit var titleDetail : TextView
    lateinit var desc : TextView
    lateinit var kkal : TextView
    lateinit var category : TextView
    lateinit var heroimg : ImageView
    lateinit var rvBahan : RecyclerView
    lateinit var rvLangkah : RecyclerView
    var listBahan = ArrayList<String>()
    var listLangkah = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_detail)

        val back : ImageView = findViewById(R.id.imgBack)
        val profil: ImageView = findViewById(R.id.about_page)

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
        val share :Button = findViewById(R.id.action_share)


        val resep = intent.getParcelableExtra<Resep>("resep")
        if (resep != null) {
            titleDetail.setText(resep.name)
            desc.setText(resep.description)
            kkal.setText(resep.calOfAmount)
            category.setText(resep.category)

            for (value in resep.ingredients){
                listBahan.add(value)
            }

            for (value in resep.steps){
                listLangkah.add(value)
            }


            Glide.with(this)
                .load(resep.photo)
                .centerCrop()
                .into(heroimg);


//            heroimg.setText(resep.category)
//            rvBahan.setText(resep.category)
        }
//        rvBahan.setHasFixedSize(true)
//        rvLangkah.setHasFixedSize(true)
        showRecyclerList()

        share.setOnClickListener({
            var intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            val bodyText = "Share makanan ${resep?.name} , ${resep?.description} "
            intent.putExtra(Intent.EXTRA_SUBJECT,resep?.name)
            intent.putExtra(Intent.EXTRA_TEXT,bodyText)
            startActivity(Intent.createChooser(intent,"Sharing Makanan Enak yuk"))
        })

    }

    private fun showRecyclerList() {
        val staggeredGridLayoutManagerBahan =
            StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL)

        val staggeredGridLayoutManagerLangkah =
            StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL)

        rvBahan.layoutManager = staggeredGridLayoutManagerBahan
        rvLangkah.layoutManager = LinearLayoutManager(this)

        val listBahanAdapter = ListBahanAdapter(listBahan)
        val listLangkahAdapter = ListBahanAdapter(listLangkah)
        rvBahan.adapter = listBahanAdapter
        rvLangkah.adapter = listLangkahAdapter
    }

}