package com.example.footballschedule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballschedule.DataClub
import com.example.footballschedule.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.liga_item.view.*

class MainAdapter(private val context: Context, private val items: List<DataClub>, private val listener: (DataClub) -> Unit):RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.liga_item, parent, false))

    override fun getItemCount(): Int  = items.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageClub = view.findViewById<ImageView>(R.id.img_liga)
        fun bindItem(items: DataClub, listener: (DataClub) -> Unit){
            itemView.txt_liga.text = items.name
            items.image?.let { Picasso.get().load(it).fit().into(imageClub) }

            itemView.setOnClickListener {
                listener(items)
            }
        }


    }
}