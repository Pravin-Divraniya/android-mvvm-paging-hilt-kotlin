package com.pravin.mvvmdiexample.viewmodel.activity

import android.view.View
import androidx.databinding.Bindable
import com.pravin.mvvmdiexample.data.model.db.Person
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.di.annotation.ActivityContext
import com.pravin.mvvmdiexample.view.navigator.PersonListActivityNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
@ActivityContext
class PersonListViewModel @Inject constructor(dataManager: DataManager) :
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