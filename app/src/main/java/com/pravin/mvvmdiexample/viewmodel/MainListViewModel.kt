package com.pravin.mvvmdiexample.viewmodel

import com.pravin.mvvmdiexample.data.model.Person
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.navigator.MainListActivityNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
class MainListViewModel(dataManager: DataManager):
        BaseViewModel<MainListActivityNavigator>(dataManager) {
    private val mDataManager: DataManager
    private val datas:List<Person>
    init {
        this.mDataManager = getDataManager()
        this.datas = mDataManager.getAllPerson()
    }
    fun getPersonList() = datas
}