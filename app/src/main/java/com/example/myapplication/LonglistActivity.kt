package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LonglistActivity : AppCompatActivity() {
    private var list = ArrayList<Resep>()
    private lateinit var rvResep: RecyclerView
    private lateinit var back: ImageView
    private lateinit var profil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_longlist)

        back = findViewById(R.id.imgBack)
        profil = findViewById(R.id.imgMenu)

        rvResep = findViewById(R.id.rvResep)
        rvResep.setHasFixedSize(true)
        getListResep()
        showRecyclerList()


        profil.setOnClickListener{
//            Toast.makeText(this,"halo",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,ProfilActivity::class.java))
        }

        back.setOnClickListener{
            finish()
        }

    }

    private fun getListResep(){

        val resep1 = Resep("koci-koci","Madura , Jawa Timur , Rank #1","330kkl","Rp.20.000","Makanan Ringan","img1.png",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))
        val resep2 = Resep("koci-koci","Madura , Jawa Timur , Rank #1","330kkl","Rp.20.000","Makanan Ringan","img1.png",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))
        val resep3 = Resep("koci-koci","Madura , Jawa Timur , Rank #1","330kkl","Rp.20.000","Makanan Ringan","img1.png",
        listOf("ketan","tepung","telur","pewarna makanan"),
        listOf("buka ketan","tutup botol","masukan ikan"))

        val resep4 = Resep("koci-koci","Madura , Jawa Timur , Rank #1","330kkl","Rp.20.000","Makanan Ringan","img1.png",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))

        list.add(resep1)
        list.add(resep2)
        list.add(resep3)
        list.add(resep4)
    }

    private fun showRecyclerList() {
        rvResep.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListResepAdapter(list)
        listHeroAdapter.onItemClick = {
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("resep",it)
            startActivity(intent)
        }
        rvResep.adapter = listHeroAdapter
    }


}