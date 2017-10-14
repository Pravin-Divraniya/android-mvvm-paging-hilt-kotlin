package com.pravin.mvvmdiexample.view.activity

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.pravin.mvvmdiexample.view.navigator.BaseNavigator
import com.pravin.mvvmdiexample.viewmodel.base.BaseViewModel
import dagger.android.AndroidInjection

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
abstract class BaseActivity<T:ViewDataBinding,V: BaseViewModel<out BaseNavigator>>: AppCompatActivity() {
    private lateinit var mViewDataBinding: T
    private var mViewModel: V? =  null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
        performDataBinding()
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil
                .setContentView(this, getLayoutId())
        this.mViewModel = if (mViewModel == null) getMyViewModel() else mViewModel
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }

    abstract fun getBindingVariable(): Int
    abstract fun getMyViewModel(): V
    @LayoutRes
    abstract fun getLayoutId():Int

    protected fun getViewDataBinding():T = mViewDataBinding

    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }
}