package com.clarion.mvvmdiexample.viewmodel.activity

import android.databinding.Bindable
import android.databinding.ObservableBoolean
import android.text.TextWatcher
import android.view.View
import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.common.MyTextWatcher
import com.clarion.mvvmdiexample.data.model.db.Person
import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.navigator.AddPersonActivityNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel

/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
class AddPersonViewModel(dataManager: DataManager):
        BaseViewModel<AddPersonActivityNavigator>(dataManager) {

    private var mPerson: Person = Person("",0)

    val isValid = ObservableBoolean()

    fun setPerson(person: Person){
        this.mPerson = person
        notifyChange()
    }

    fun setPersonName(name:String){
        mPerson.name = name
        notifyPropertyChanged(BR.personName)
    }

    @Bindable
    fun getPersonName() = mPerson.name

    fun setPersonAge(age:Int){
        mPerson.age = age
        notifyPropertyChanged(BR.personAge)
    }

    @Bindable
    fun getPersonAge():String{
        if(mPerson.age<=0)
            return ""
        else
            return mPerson.age.toString()
    }

    @Bindable
    fun getOnPersonNameChanged(): TextWatcher {
        return object : MyTextWatcher() {
            override fun onTextChanged(newValue: Any?) {
                validate()
                setPersonName(newValue.toString())
            }
        }
    }

    @Bindable
    fun getOnPersonAgeChanged(): TextWatcher {
        return object : MyTextWatcher() {
            override fun onTextChanged(newValue: Any?) {
                validate()
                if(!newValue.toString().isNullOrEmpty())
                    setPersonAge(newValue.toString().toInt())
                else
                    setPersonAge(0)
            }
        }
    }

    @Bindable
    fun getOnSaveClick() = View.OnClickListener { getNavigator()!!.openListActivity(mPerson) }

    private fun validate(){
        val isNameValid = !getPersonName().isNullOrEmpty()
        val isAgeValid = !getPersonAge().isNullOrEmpty()
        isValid.set(isNameValid && isAgeValid)
        notifyChange()
    }
}