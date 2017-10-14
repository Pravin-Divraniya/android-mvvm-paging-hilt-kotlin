package com.pravin.mvvmdiexample.viewmodel

import android.databinding.Bindable
import android.text.TextWatcher
import android.view.View
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.common.MyTextWatcher
import com.pravin.mvvmdiexample.data.model.Person
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.navigator.MainActivityNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
class MainActivityViewModel(dataManager: DataManager):
        BaseViewModel<MainActivityNavigator>(dataManager) {
    private val mDataManager: DataManager
    private val person:Person
    init {
        person = Person("Default",25)
        this.mDataManager = getDataManager()
    }
    fun setPersonName(name:String){
        person.name = name
        notifyPropertyChanged(BR.personName)
    }
    @Bindable
    fun getPersonName() = person.name

    fun setPersonAge(age:Int){
        person.age = age
        notifyPropertyChanged(BR.personAge)
    }
    @Bindable
    fun getPersonAge() = person.age

    @Bindable
    fun getOnPersonNameChanged(): TextWatcher {

        return object : MyTextWatcher() {
            override fun onTextChanged(newValue: Any?) {
                setPersonName(newValue.toString())
            }
        }
    }

    @Bindable
    fun getOnPersonAgeChanged(): TextWatcher {
        return object : MyTextWatcher() {
            override fun onTextChanged(newValue: Any?) {
                if(!newValue.toString().isNullOrEmpty())
                     setPersonAge(newValue.toString().toInt())
            }
        }
    }

    @Bindable
    fun getOnSaveClick():View.OnClickListener{
        return object : View.OnClickListener{
            override fun onClick(p0: View?) {
                mDataManager.insertPerson(person)
                (getNavigator() as MainActivityNavigator).openListActivity()
            }
        }
    }
}