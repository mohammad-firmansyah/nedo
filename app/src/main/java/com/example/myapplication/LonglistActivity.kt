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
        profil = findViewById(R.id.about_page)

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
            listOf("250 g tepung beras","10 ml endapan jus pandan","50 gr tepung tapioka","80 gr gula aren atau gula Jawa","100 ml air","1/4 sdt garam"," Pisang raja atau pisang lain yang matang, iris-iris bulat"),
            listOf(" Rebus gula aren dengan air hingga gula mencair, dinginkan, kemudian campur semua bahan kecuali pisang, aduk rata hingga gula larut dan semua bahan tercampur rata",
            "Panaskan kukusan, oles cetakan dengan minyak, lalu tata pisang","Tuang sedikit adonan sampai menutupi pisang, jangan terlalu banyak supaya pisang tidak naik ke atas, kukus sebentar sekitar 10 meni"," Tambahkan pisang lagi lalu tuang adonan hingga penuh, kukus 15 menit. Angkat, tunggu dingin, lalu keluarkan dari cetakan"))

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
        listOf("Haluskan bumbu halus dengan ulegan atau food processor, sisihkan",
        "Rebus daging sapi hingga mendidih, buang busa kotorannya.",
        "Masukkan bumbu rempah basah, masak sampai daging empuk dan kaldunya harum.",
        "Panaskan 3 sdm minyak, tumis bumbu halus sampai harum. Masukkan bumbu rempah kering, tumis sebentar lagi.",
        "Masukkan bumbu halus yang sudah ditumis ke dalam rebusan kaldu. Beri garam dan kaldu sapi bubuk, aduk rata dan koreksi rasanya.",
        "Kecilkan api, angkat dagingnya, angkat juga bumbu rempahnya agar kuah bersih. Tiriskan daging dan dinginkan.",
        "Iris tipis daging melawan serat, memarkan dengan ulekan bila perlu.","Panaskan minyak, goreng irisan daging sampai kering dan renyah. Angkat dan sisihkan.",
        "Untuk penyajian, tata soun, daging goreng dan perkedel kentang diatas mangkuk saji. Taburi dengan irisan seledri.",
        "Siram dengan kuah panas"))

        val resep4 = Resep("Bubur Manado","Manado , Sulawesi , Rank #19","8890kkl","Rp.120.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122810-1000xauto-makanan-daerah.jpg",
            listOf("Beras, cuci bersih lalu tiriskan - 100 gram","Labu kuning kupas, potong dadu - 200 gram","Singkong, kupas potong dadu - 100 gram","Jagung manis, pipil - 1 buah","Daun bayam - 1 mangkuk kecil","Daun kangkung - 1 mangkuk kecil","Daun kemangi - 1 mangkuk kecil","Jahe, memarkan - 1 cm"),
            listOf("Didihkan air dalam panci.","Masukkan beras, jahe, dan serai. Masak hingga mendidih dan biarkan setengah jadi bubur.","Masukkan labu kuning, singkong, jagung. Aduk rata.","Beri gula, garam, lada, dan bawang putih. Aduk rata. Masak hingga jadi berbentuk bubur dan singkong serta labu kuning jadi empuk.","Masukkan bayam, kangkung, dan daun kemangi. Aduk rata. Masak sebentar hingga sayuran matang. Angkat.","Siap disajikan dengan bahan pelengkap."))


        val resep5 = Resep("Sop Konro","Makassar , Sulawesi , Rank #29","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122802-makanan-daerah.jpg",
            listOf("Iga Sapi - 1 kg","Air - 1,5 liter","Bawang merah - 6 butir","Bawang putih - 3 siung","Kluwak, rendam air panas - 3 buah"),
            listOf("Dalam panci, rebus iga sapi bersama air. Buang kotoran dan minyak yang mengapung.","Matikan api setelah daging empuk. Pisahkan iga sapi dengan air rebusannya (kaldu) lalu sisihkan.","Tumis bumbu halus bersama bahan-bahan lainnya hingga wangi dan tidak langu.","Tuang air rebusan (kaldu) iga dalam tumisan bumbu. Aduk rata.","Masukkan iga sapi, gula merah, kaldu bubuk, dan garam. Masak sampai bumbu meresap dan kuah agak mengental. Koreksi rasanya lalu angkat.","Sajikan dengan taburan bawang goreng dan irisan daun bawang."))

        val resep6 = Resep("Sate lilit ayam khas Bali","Bali , Bali , Rank #19","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122809-1000xauto-makanan-daerah.jpg",
            listOf("500 gr daging ayam","3 batang sereh","3 cabai merah besar","10 cabai merah rawit","1 lembar daun jeruk"),
            listOf("Potong haluskan semua bumbu genep menggunakan food processor menjadi satu","Sementara itu, iris tipis-tipis sereh, cabe merah besar dan rawit","Tumis bumbu genep dan irisan tipis sereh dan cabai menjadi satu. Tambahkan daun jeruk, daun salam, dan terasi","Masukkan juga kaldu bubu dan garam. Aduk sampai rata","Sementara itu, haluskan daging ayam","Sementara itu, haluskan daging ayam","Campurkan ayam yang sudah dihaluskan dengan tiga sendok makan bumbu genep yang sudah ditumis tadi","Tambahkan kelapa parut, gula aren. Aduk menjadi satu","Tambahkan lagi bumbu basa genep jika dianggap masih kurang.",))


        val resep7 = Resep("Candil ketan","Madura , Jawa Timur , Rank #123","900kkl","Rp.15.000","Makanan Ringan","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122811-1000xauto-makanan-daerah.jpg",
            listOf("100 gr tepung ketan","1 sdm tepung tapioka","1/4 sdt garam","100 ml air panas (secukupnya sampai adonan bisa di bulat2kan)","2 lembar daun pandan"),
            listOf("Bahan Siraman: Campurkan semua bahan siraman. Masak di atas kompor sambil terus diaduk-aduk hingga mendidih. Angkat dan sisihkan.","Campur tepung ketan dan garam.","Aduk campuran dan uleni sambil dituang air hangat sedikit demi sedikit, sampai adonan bisa dibentuk.","Panaskan banyak air dalam panci. Biarkan sampai mendidih.","Ambil dan bentuk adonan menjadi seukuran kelereng. Masukkan dalam air mendidih. Rebus hingga adonan candil mengapung. Angkat dan tiriskan."))

        val resep8 = Resep("Pempek Palembang","Palembang , Sumatera , Rank #129","890kkl","Rp.12.000","Makanan Ringan","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122808-1000xauto-makanan-daerah.jpg",
            listOf("250 gr ikan giling","100 gr tepung tapioka/sagu","1 sdm garam","1 sdt kaldu jamur","1/2 sdt gula pasir","100 ml air es","1 buah telur ayam"),
            listOf("Siapkan semua bahan, lalu masukkan daging ikan giling dan air. Kemudian aduk rata dan tambahkan lada.","Setelah itu tambahkan telur ayam aduk kembali hingga rata.","Masukkan garam, kaldu jamur dan gula pasir, periksa rasa dan tambahkan bawang merah serta daun bawang, aduk rata.","Kemudian tambahkan tapioka masukkan secara perlahan sedikit demi sedikit aduk dengan spatula.","Bentuk adonan seperti bakso, lalu goreng adonan pempek yang telah dibentuk kedalam minyak panas gunakan api kecil cenderung sedang.","Moms disarankan untuk menggunakan minyak yang banyak dan goreng pempek jangan terlalu penuh agar pempek bisa membentuk bulat.","Goreng pempek hingga kekuningan.","Jika sudah kekuningan dan terlihat mengembang angkat lalu tiriskan"))

        val resep9 = Resep("Seblak Bandung","Bandung , Jawa Barat , Rank #17","990kkl","Rp.10.000","Makanan Ringan","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122807-1000xauto-makanan-daerah.jpg",
            listOf("6 sdm minyak goreng","3 butir telur","1 potong ayam goreng bagian paha, suwir-suwir","3 batang sawi hijau, potong-potong","2 batang daun bawang, iris halus","200 g kerupuk bawang, rendam air panas hingga mengembang, tiriskan","750 ml air","1 sdt kaldu ayam bubuk","1½ sdm kecap manis"),
            listOf("Panaskan 4 sdm minyak dalam wajan, masak telur menjadi orak arik. Tambahkan sisa minyak, masukkan bumbu halus, tumis hingga harum.","Tambahkan ayam suwir, sawi hijau, dan daun bawang, aduk hingga setengah layu.","Masukkan kerupuk bawang, air, kaldu ayam, dan kecap manis, aduk rata. Masak hingga mendidih. Angkat, sajikan segera."))

        val resep10 = Resep("Batagor Bandung","Bandung , Jawa Barat , Rank #15","880kkl","Rp.100.000","Makanan Utama","https://cdn-brilio-net.akamaized.net/webp/news/2019/11/05/173525/1122806-1000xauto-makanan-daerah.jpg",
            listOf("Ikan tenggiri fillet, haluskan - 300 gram","Tepung sagu - 150 gram","Kulit pangsit - 10 lembar","Tahu putih / kuning - 6 buah","Daun bawang iris halus - 2 batang","Merica - 1/2 sdt",),
            listOf("Dalam wadah, campur daging ikan, tepung sagu, daun bawang, merica, gula, dan garam. Aduk rata."," Tuangkan air sedikit demi sedikit sambil terus diaduk hingga adonan mengental.","Siapkan tahu segitiga dan kulit pangsit. Isi tahu dengan 1 sdm adonan daging lalu ratakan. Taruh 1 sdm adonan daging di tengah kulit pangsit lalu rekatkan di tengahnya hingga berbentuk seperti bunga. Lakukan hingga semua adonan habis."," Panaskan banyak minyak dalam wajan. Goreng tahu dan pangsit hingga kuning kecoklatan dan matang. Angkat dan tiriskan.","Siap disajikan dengan siraman saus/sambal kacang"))

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