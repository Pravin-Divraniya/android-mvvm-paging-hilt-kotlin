package com.clarion.mvvmdiexample.view.activity

import android.os.Bundle
import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.R
import com.clarion.mvvmdiexample.databinding.ActivityMainBinding
import com.clarion.mvvmdiexample.view.fragment.MainFragment
import com.clarion.mvvmdiexample.view.navigator.MainActivityNavigator
import com.clarion.mvvmdiexample.viewmodel.activity.MainViewModel
import javax.inject.Inject

/**
 * Created by Pravin Divraniya
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>()
        ,MainActivityNavigator {

    @Inject
    protected lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init(){
        viewModel.setNavigator(this)
        startLocationUpdates()
        openMainFragment()
    }

    private fun openMainFragment() {
        viewModel.setFrgTitle(getString(R.string.title_main_fragment))

        val ft = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(MainFragment.TAG)

        if(null == fragment) {
            fragment = MainFragment.newInstance(getApiKey(), viewModel)

            ft.disallowAddToBackStack()
                    .add(R.id.frg_container, fragment,
                            MainFragment.TAG)
                    .commit()
        }
    }

    override fun onBackPressed() {
        hideLoading()
        hideKeyboard()
        viewModel.setFrgTitle(getString(R.string.title_main_fragment))
        super.onBackPressed()
    }

    override fun getBindingVariable() = BR.mainViewModel
    override fun getMyViewModel() = viewModel
    override fun getLayoutId()= R.layout.activity_main

}
