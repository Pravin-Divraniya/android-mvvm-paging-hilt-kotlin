package com.pravin.mvvmdiexample.view.activity

import android.content.Intent
import android.os.Bundle
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.databinding.ActivityMainBinding
import com.pravin.mvvmdiexample.view.navigator.MainActivityNavigator
import javax.inject.Inject
import com.pravin.mvvmdiexample.viewmodel.MainActivityViewModel


class MainActivity : BaseActivity<ActivityMainBinding,MainActivityViewModel>(),MainActivityNavigator {
    @Inject
    protected lateinit var viewModel: MainActivityViewModel
    private lateinit var mMainActBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }
    fun init(){
        mMainActBinding = getViewDataBinding()
        viewModel.setNavigator(this)
    }
    override fun getLayoutId() = R.layout.activity_main
    override fun getBindingVariable() = BR.viewmodel
    override fun getMyViewModel() = viewModel

    override fun openListActivity() {
        val intent = Intent(this,MainListActivity::class.java)
        startActivity(intent)
    }
}
