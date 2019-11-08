package com.example.footballschedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footballschedule.adapter.MainAdapter
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    var  items: MutableList<DataClub> = mutableListOf()
    companion object{
        public const val PARCELABLE_ITEM_DATA = "item data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.recycle_league)
        initData()

        //list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        list.adapter = MainAdapter(this, items){
            startActivity<DetailLeagueActivity>()
        }
        list.layoutManager = LinearLayoutManager(this)
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.league)
        val image = resources.obtainTypedArray(R.array.imageLanguange)
        items.clear()
        for (i in name.indices){
            items.add(DataClub(image.getResourceId(i, 0)
                , name[i]))
        }
        image.recycle()
    }
}
