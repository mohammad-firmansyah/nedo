package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListResepAdapter(private val listResep: ArrayList<Resep>): RecyclerView.Adapter<ListResepAdapter.ListViewHolder>() {


    public var onItemClick : ((Resep) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
         val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_longlist, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listResep[position]
//        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(listResep[position])
        }
    }

    override fun getItemCount(): Int {
        return listResep.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.hero)
        var tvName: TextView = itemView.findViewById(R.id.title)
        var tvDescription: TextView = itemView.findViewById(R.id.subTitle)
    }
}

class OnItemClickCallback {

}
