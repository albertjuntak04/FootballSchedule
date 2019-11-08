package com.example.footballschedule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapi.model.Team
import com.example.footballschedule.DataClub
import com.example.footballschedule.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.club_item.view.*

class SlideClubAdapter(private val context: Context, private val teams: List<Team>)
    : RecyclerView.Adapter<SlideClubAdapter.TeamViewHolder>() {
    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val imageClub = view.findViewById<ImageView>(R.id.img_club)
        fun bindItem(teams: Team){
            Picasso.get().load(teams.teamBadge).into(imageClub)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TeamViewHolder(
        LayoutInflater.from(context).inflate(R.layout.club_item, parent, false)
    )


    override fun getItemCount(): Int = teams.size


    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position])
    }
}

