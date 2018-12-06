package com.clarion.mvvmdiexample.viewmodel.list

import android.databinding.Bindable
import android.view.View
import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.data.model.db.Person
import com.clarion.mvvmdiexample.view.navigator.PersonListNavigator
import com.clarion.mvvmdiexample.viewmodel.base.ListItemViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
class PersonItemViewModel : ListItemViewModel<Person>() {

    private lateinit var person: Person

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

    @Bindable
    fun getOnLongClick(): View.OnLongClickListener{
        return View.OnLongClickListener {
            (getNavigator() as PersonListNavigator).longClickedItem(person)
            true
        }
    }
}