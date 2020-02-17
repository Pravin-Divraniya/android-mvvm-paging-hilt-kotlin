package com.pravin.mvvmdiexample.viewmodel.activity

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.navigator.PagerActivityNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 12/15/2017.
 */
class PagerViewModel(dataManager:DataManager):
        BaseViewModel<PagerActivityNavigator>(dataManager) {

    val adapter = ObservableField<FragmentPagerAdapter>()

    companion object {
        @JvmStatic
        @BindingAdapter("app:mAdapter")
        fun setPagerAdapter(viewPager: ViewPager, pagerAdapter:FragmentPagerAdapter?){
            if(null == pagerAdapter)
                return
            viewPager.adapter = pagerAdapter
        }
    }
}