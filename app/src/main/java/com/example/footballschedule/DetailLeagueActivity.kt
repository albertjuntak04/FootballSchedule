package com.example.footballschedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapi.MainPresenter
import com.example.footballapi.model.Team
import com.example.footballschedule.adapter.PagerAdapter
import com.example.footballschedule.adapter.SlideClubAdapter
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailLeagueActivity : AppCompatActivity() {
    internal  lateinit var viewpageAdapter: PagerAdapter
    private var teams: MutableList<Team> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: SlideClubAdapter
    private lateinit var listTeam: RecyclerView
    private lateinit var leagueName: String

    override fun showTeamList(data: List<Team>) {
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)



        viewpageAdapter = PagerAdapter(supportFragmentManager)
        this.view_pager.adapter = viewpageAdapter
        tablayout.setupWithViewPager(view_pager)
    }
}
