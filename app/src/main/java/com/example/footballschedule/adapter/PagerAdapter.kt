package com.example.footballschedule.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.footballschedule.NextMatch
import com.example.footballschedule.PreviousMatch


class PagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val pages = listOf(
        NextMatch(),
        PreviousMatch()

    )

    override fun getItem(position: Int): Fragment {
        return  pages[position]
    }



    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence?{
        var title: String? = null
        return when(position){
            0 -> "First Tab"
            else -> "Second Tab"

        }
    }
}

