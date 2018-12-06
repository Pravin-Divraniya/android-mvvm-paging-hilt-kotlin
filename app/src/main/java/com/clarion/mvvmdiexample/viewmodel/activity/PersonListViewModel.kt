package com.clarion.mvvmdiexample.viewmodel.activity

import android.databinding.Bindable
import android.view.View
import com.clarion.mvvmdiexample.data.model.db.Person
import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.navigator.PersonListActivityNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
class PersonListViewModel(dataManager: DataManager) :
        BaseViewModel<PersonListActivityNavigator>(dataManager) {
    private val mDataManager: DataManager = getDataManager()
    private val datas: List<Person> = mDataManager.getAllPerson()

    fun getPersonList() = datas

    fun insertPerson(person: Person) {
        mDataManager.insertPerson(person)
    }

    fun deletePerson(person: Person) {
        mDataManager.deletePerson(person)
    }

    fun updatePerson(person: Person){
        mDataManager.updatePerson(person)
    }

    @Bindable
    fun getOnSaveClick() = View.OnClickListener {getNavigator()!!.openAddEditPersonScreen(null)}
}