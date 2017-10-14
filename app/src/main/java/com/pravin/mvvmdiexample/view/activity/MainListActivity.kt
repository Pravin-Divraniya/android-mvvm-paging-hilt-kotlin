package com.pravin.mvvmdiexample.view.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.databinding.ActivityMainListBinding
import com.pravin.mvvmdiexample.view.adapter.PersonListAdapter
import com.pravin.mvvmdiexample.view.navigator.MainListActivityNavigator
import com.pravin.mvvmdiexample.viewmodel.MainListViewModel
import kotlinx.android.synthetic.main.activity_main_list.*
import javax.inject.Inject

class MainListActivity : BaseActivity<ActivityMainListBinding,MainListViewModel>(),
                                    MainListActivityNavigator{
    @Inject
    protected lateinit var viewModel:MainListViewModel

    private lateinit var mActivityMainListBinding:ActivityMainListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    fun init() {
        mActivityMainListBinding = getViewDataBinding()
        viewModel.setNavigator(this)

        val adapter = PersonListAdapter(viewModel.getPersonList())
        rc_person_list.layoutManager = LinearLayoutManager(this)
        rc_person_list.adapter = adapter
    }
    override fun getLayoutId() = R.layout.activity_main_list
    override fun getBindingVariable() = BR.viewmodel
    override fun getMyViewModel() = viewModel
    override fun goBack() {
        finish()
    }
}
