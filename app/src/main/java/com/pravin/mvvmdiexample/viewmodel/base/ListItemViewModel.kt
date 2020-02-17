package com.pravin.mvvmdiexample.viewmodel.base

import com.pravin.mvvmdiexample.view.navigator.BaseNavigator

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
abstract class ListItemViewModel<ITEM>: ViewModel() {
    abstract fun setItem(item:ITEM)
    abstract fun getItem(): ITEM

    private lateinit var mNavigator: BaseNavigator

    fun setNavigator(navigator:BaseNavigator){
        mNavigator = navigator
    }

    fun getNavigator() = mNavigator
}