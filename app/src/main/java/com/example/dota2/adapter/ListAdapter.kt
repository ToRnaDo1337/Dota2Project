package com.example.dota2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2.R
import com.example.dota2.data.model.Responsibility
import com.google.android.material.imageview.ShapeableImageView

class ListAdapter(private val context: ArrayList<Responsibility>
) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val resText: TextView = itemView.findViewById(R.id.tvHeading)
        val Timage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val doneby: TextView = itemView.findViewById(R.id.textView6)





    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = context.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = context[position]
        holder.Timage.setImageResource(item.ImgResourceId)
        holder.resText.text=item.Restext
        holder.doneby.text=item.Doneby
       /* holder.textView.text = context.resources.getString(item.stringResourceId)*/

    }
}