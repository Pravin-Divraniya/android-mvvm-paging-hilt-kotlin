package com.pravin.mvvmdiexample.view.activity

import android.os.Bundle
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.databinding.ActivityPagerBinding
import com.pravin.mvvmdiexample.view.adapter.BasePagerAdapter
import com.pravin.mvvmdiexample.viewmodel.activity.PagerViewModel
import javax.inject.Inject

/**
 * Created by Pravin Divraniya on 12/15/2017.
 */
class PagerActivity : BaseActivity<ActivityPagerBinding, PagerViewModel>(){
    @Inject
    lateinit var viewModel: PagerViewModel

    @Inject
    lateinit var adapter:BasePagerAdapter

    override fun getBindingVariable() = BR.pagerViewModel
    override fun getMyViewModel() = viewModel
    override fun getLayoutId() = R.layout.activity_pager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        viewModel.adapter.set(adapter)
    }
}
