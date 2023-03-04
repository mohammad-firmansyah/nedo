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

        val resep1 = Resep("koci-koci","Madura , Jawa Timur , Rank #290","330kkl","Rp.20.000","Makanan Ringan","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122810-1000xauto-makanan-daerah.jpg",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))
        val resep2 = Resep("Nagasari","Surabaya , Jawa Timur , Rank #77","1000kkl","Rp.10.000","Makanan Ringan","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122805-makanan-daerah.jpg",
            listOf("kacang","tepung","telur","pewarna makanan","tepung maizena"),
            listOf("tumbuk kacang","masak air","masukan kacang","masukan tepung ke adonan","masukan pewarna makanan"))

        val resep3 = Resep("Soto Padang","Padang , Sumatra Barat , Rank #10","440kkl","Rp.50.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122812-makanan-daerah.jpg",
        listOf("500 gram daging sapi",
                "2 liter air",
                "minyak goreng untuk menumis",
        "2 batang sereh digeprek" +
                "- 3 lembar daun salam.\n",
                "4 lembar daun jeruk",
                "5 buah kapulaga",
                "8 kelopak bunga lawang",
                "5 buah cengkeh",
                "4 cm kayu manis",
                "2 batang daun bawang diiris"),
        listOf("buka ketan","tutup botol","masukan ikan"))

        val resep4 = Resep("Bubur Manado","Manado , Sulawesi , Rank #19","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122810-1000xauto-makanan-daerah.jpg",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))

        val resep5 = Resep(" Sop Konro","Manado , Sulawesi , Rank #19","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122802-makanan-daerah.jpg",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))

        val resep6 = Resep(" Sate lilit ayam khas Bali","Manado , Sulawesi , Rank #19","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122809-1000xauto-makanan-daerah.jpg",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))

        val resep7 = Resep("Candil ketan","Manado , Sulawesi , Rank #19","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122811-1000xauto-makanan-daerah.jpg",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))

        val resep8 = Resep("Pempek Palembang","Manado , Sulawesi , Rank #19","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122808-1000xauto-makanan-daerah.jpg",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))

        val resep9 = Resep("Seblak Bandung","Manado , Sulawesi , Rank #19","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122807-1000xauto-makanan-daerah.jpg",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))

        val resep10 = Resep("Batagor Bandung","Manado , Sulawesi , Rank #19","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122806-1000xauto-makanan-daerah.jpg",
            listOf("ketan","tepung","telur","pewarna makanan"),
            listOf("buka ketan","tutup botol","masukan ikan"))

        list.add(resep1)
        list.add(resep2)
        list.add(resep3)
        list.add(resep4)
        list.add(resep5)
        list.add(resep6)
        list.add(resep7)
        list.add(resep8)
        list.add(resep9)
        list.add(resep10)
    }

    private fun showRecyclerList() {
        rvResep.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListResepAdapter(this,list)
        listHeroAdapter.onItemClick = {
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("resep",it)
            startActivity(intent)
        }
        rvResep.adapter = listHeroAdapter
    }


}