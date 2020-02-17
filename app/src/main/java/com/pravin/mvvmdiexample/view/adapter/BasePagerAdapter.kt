package com.pravin.mvvmdiexample.view.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.pravin.mvvmdiexample.utils.ConstantData.NUM_OF_PAGES
import com.pravin.mvvmdiexample.view.fragment.PageFragment

/**
 * Created by Pravin Divraniya on 12/19/2017.
 */
class BasePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int) = PageFragment.newInstance(position)
    override fun getCount() = NUM_OF_PAGES
}