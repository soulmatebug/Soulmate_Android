package com.example.tripplanner

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter

class PageAdapter(fm : android.support.v4.app.FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                First()
            }
            1 -> {
                Second()
            }
            2 -> {
                Third()
            }
            else -> {
                return Fourth()
            }
        }


    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "tab1"
            1 -> "tab2"
            2 -> "tab3"
            else -> {return "tab4"}
        }
    }

}