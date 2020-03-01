package com.pravin.mvvmdiexample.viewmodel.list

import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.pravin.mvvmdiexample.data.model.db.Person
import com.pravin.mvvmdiexample.di.annotation.ActivityContext
import com.pravin.mvvmdiexample.view.navigator.PersonListNavigator
import com.pravin.mvvmdiexample.viewmodel.base.ListItemViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */

@ActivityContext
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