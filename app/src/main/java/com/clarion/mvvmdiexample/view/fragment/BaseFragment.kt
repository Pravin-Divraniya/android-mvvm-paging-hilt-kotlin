package com.clarion.mvvmdiexample.view.fragment

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clarion.mvvmdiexample.view.activity.BaseActivity
import com.clarion.mvvmdiexample.view.navigator.BaseNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel
import dagger.android.support.DaggerFragment

/**
 * Created by Pravin Divraniya on 11/21/2017.
 */
abstract class BaseFragment<out T:ViewDataBinding,out V:BaseViewModel<out BaseNavigator>>
    : DaggerFragment() {
    private var mActivity: BaseActivity<*,*>? = null
    private lateinit var mViewDataBinding: T
    private lateinit var mViewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        val mRootView = mViewDataBinding.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = getViewModel()
        mViewDataBinding.setVariable(getBindingVariable(),mViewModel)
        mViewDataBinding.executePendingBindings()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is BaseActivity<*, *>){
            mActivity = context
        }
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    fun isNetworkConnected() = mActivity != null && mActivity!!.isNetworkConnected()

    fun hideKeyboard() {
        if (mActivity != null) {
            mActivity!!.hideKeyboard()
        }
    }
    fun showLoading(){
        if (mActivity != null)
            mActivity!!.showLoading()

    }

    fun hideLoading(){
        if (mActivity != null) {
            mActivity!!.hideLoading()
        }
    }

    fun getBaseActivity() = mActivity
    fun getViewBinding() = mViewDataBinding

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): V

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int
}