package com.clarion.mvvmdiexample.view.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.clarion.mvvmdiexample.utils.ConstantData.NUM_OF_PAGES
import com.clarion.mvvmdiexample.view.fragment.PageFragment

/**
 * Created by Pravin Divraniya on 12/19/2017.
 */
class BasePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int) = PageFragment.newInstance(position)
    override fun getCount() = NUM_OF_PAGES
}