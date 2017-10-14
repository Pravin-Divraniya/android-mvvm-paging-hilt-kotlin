package com.pravin.mvvmdiexample.viewmodel.base

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
abstract class ListItemViewModel<T>: ViewModel() {
    abstract fun setItem(item:T)
    abstract fun getItem(): T
}