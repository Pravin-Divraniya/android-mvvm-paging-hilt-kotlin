package com.pravin.mvvmdiexample.viewmodel

import android.databinding.Bindable
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.data.model.Person
import com.pravin.mvvmdiexample.viewmodel.base.ListItemViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
class PersonItemViewModel: ListItemViewModel<Person>() {

    private lateinit var person:Person

    override fun getItem() = person
    override fun setItem(item: Person) {
        this.person = item
        notifyChange()
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
    fun getPersonAge() = person.age.toString()
}