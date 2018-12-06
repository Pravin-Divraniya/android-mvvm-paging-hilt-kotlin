package com.clarion.mvvmdiexample.viewmodel.activity

import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.navigator.PagerActivityNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 12/15/2017.
 */
class PagerViewModel(dataManager:DataManager):
        BaseViewModel<PagerActivityNavigator>(dataManager) {

    val adapter = ObservableField<FragmentPagerAdapter>()

    companion object {
        @JvmStatic
        @BindingAdapter("app:mAdapter")
        fun setPagerAdapter(viewPager:ViewPager,pagerAdapter:FragmentPagerAdapter?){
            if(null == pagerAdapter)
                return
            viewPager.adapter = pagerAdapter
        }
    }
}