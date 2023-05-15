package com.example.PagerAdapter

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hammod736.om.hekma.ui.homePage.homeFragments.AllWisdom
import com.hammod736.om.hekma.ui.homePage.homeFragments.FavoriteWisdom

class PagerClass(fragment:Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {AllWisdom()}
            1 -> {FavoriteWisdom()}
            else -> {throw IllegalAccessException("INVALID FRAGMENT")}
        }
    }
}