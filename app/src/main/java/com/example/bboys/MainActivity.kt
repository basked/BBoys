package com.example.bboys

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    class BBoy(
        private var rating: Int,
        private var nickname: String,
        private var country: String,
        private var img: Int
    ) {
        fun getRating(): Int {
            return rating
        }

        fun getCountry(): String {
            return country
        }

        fun getNickname(): String {
            return nickname
        }

        fun getImg(): Int {
            return img
        }
    }

    class BBoyAdapter(private var c: Context, private var bboys: ArrayList<BBoy>) : BaseAdapter() {
        override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
            var view = view
            if (view == null) {
                view = LayoutInflater.from(c).inflate(R.layout.row_model, viewGroup, false)
            }
            // get current bboy
            val bboy = this.getItem(i) as BBoy
            // regerencetextviews and imageviews from our layout
            val img = view!!.findViewById<ImageView>(R.id.imageView)
            val rating = view.findViewById<TextView>(R.id.textRating)
            val nickname = view.findViewById<TextView>(R.id.textNick)
            val country = view.findViewById<TextView>(R.id.textCountry)

            // BIND data to TextView and ImageView
            img.setImageResource(bboy.getImg())
            rating.text = bboy.getRating().toString()
            nickname.text = bboy.getNickname()
            country.text = bboy.getCountry()
            rating.text = bboy.getRating().toString()

            // handle itemclicks for the GridView
            view.setOnClickListener {
                Toast.makeText(
                    c,
                    "Rating bboy ${bboy.getNickname()} equal ${bboy.getRating()}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            return view
        }

        override fun getItem(position: Int): Any {
            return bboys[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return bboys.size
        }

    }

    // Main Activity Instance Fields
    private lateinit var adapter: BBoyAdapter;
    private lateinit var gv: GridView

    // our data source
    private val data: ArrayList<BBoy>
        get() {
            val bboys = ArrayList<BBoy>()
            var bboy = BBoy(1, "Lilou", "France", R.drawable.lilou)
            bboys.add(bboy)
            bboy = BBoy(2, "Menno", "Netherland", R.drawable.menno)
            bboys.add(bboy)
            bboy = BBoy(3, "Hong 10", "Shouth Korea", R.drawable.hong_10)
            bboys.add(bboy)
            bboy = BBoy(4, "El Nino", "USA", R.drawable.el_nino)
            bboys.add(bboy)
            bboy = BBoy(5, "Taisuke", "Japan", R.drawable.taisuke)
            bboys.add(bboy)
            bboy = BBoy(6, "Alkolil", "Russia", R.drawable.alkolil)
            bboys.add(bboy)
            bboy = BBoy(7, "Mounir", "France", R.drawable.mounir)
            bboys.add(bboy)
            bboy = BBoy(8, "Issei", "Japan", R.drawable.issei)
            bboys.add(bboy)
            bboy = BBoy(9, "Sunni", "British", R.drawable.sunni)
            bboys.add(bboy)
            bboy = BBoy(10, "Roxrite", "USA", R.drawable.roxrite)
            bboys.add(bboy)
            return bboys
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gv= findViewById(R.id.myGridView)
        adapter = BBoyAdapter(this,data)
        gv.adapter=adapter

    }


}
