package com.pravin.mvvmdiexample.view.adapter

import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.db.Person
import com.pravin.mvvmdiexample.view.navigator.PersonListNavigator
import com.pravin.mvvmdiexample.viewmodel.list.PersonItemViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
class PersonListAdapter(datas:MutableList<Person>,listNavigator: PersonListNavigator):
        BaseRVAdapter<Person, PersonItemViewModel>(datas) {

    private val navigator = listNavigator

    override fun getLayoutId() = R.layout.raw_person_list
    override fun getVariableId() = BR.personItemViewmodel
    override fun getViewModel(): PersonItemViewModel {
        val viewModel = PersonItemViewModel()
        viewModel.setNavigator(navigator)
        return viewModel
    }
}