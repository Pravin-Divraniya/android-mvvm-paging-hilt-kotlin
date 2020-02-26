package com.pravin.mvvmdiexample.viewmodel.activity

import android.text.TextWatcher
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.ObservableBoolean
import androidx.databinding.library.baseAdapters.BR
import com.pravin.mvvmdiexample.common.MyTextWatcher
import com.pravin.mvvmdiexample.data.model.db.Person
import com.pravin.mvvmdiexample.data.model.manager.DataManager
import com.pravin.mvvmdiexample.view.navigator.AddPersonActivityNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
class AddPersonViewModel @Inject constructor(dataManager: DataManager):
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
        return if(mPerson.age<=0)
            ""
        else
            mPerson.age.toString()
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
                if(newValue.toString().isNotEmpty())
                    setPersonAge(newValue.toString().toInt())
                else
                    setPersonAge(0)
            }
        }
    }

    @Bindable
    fun getOnSaveClick() = View.OnClickListener { getNavigator()!!.openListActivity(mPerson) }

    private fun validate(){
        val isNameValid = getPersonName().isNotEmpty()
        val isAgeValid = getPersonAge().isNotEmpty()
        isValid.set(isNameValid && isAgeValid)
        notifyChange()
    }
}