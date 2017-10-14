package com.pravin.mvvmdiexample.view.adapter

import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.Person
import com.pravin.mvvmdiexample.viewmodel.PersonItemViewModel
import com.pravin.mvvmdiexample.viewmodel.base.ListItemViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
class PersonListAdapter(datas:List<Person>):
        BaseRVAdapter<Person,ListItemViewModel<Person>>(datas) {
    override fun getLayoutId() = R.layout.raw_person_list
    override fun getViewModel() = PersonItemViewModel()
}