package com.clarion.mvvmdiexample.view.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.clarion.mvvmdiexample.data.model.BaseModel
import com.clarion.mvvmdiexample.viewmodel.base.ListItemViewModel

abstract class BaseListAdapter<TYPE:BaseModel,
        VM:ListItemViewModel<TYPE>>(itemCallback: DiffUtil.ItemCallback<TYPE>):
        ListAdapter<TYPE,
                BaseRVAdapter.Companion.BaseViewHolder<TYPE,VM>>(itemCallback) {

    override fun onBindViewHolder(holder: BaseRVAdapter.Companion.BaseViewHolder<TYPE, VM>, position: Int) {
        holder.setItem(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRVAdapter.Companion.BaseViewHolder<TYPE, VM> {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutId(),parent,false)
        val mDataBinding = DataBindingUtil.bind<ViewDataBinding>(view)
        val viewModel = getViewModel()
        mDataBinding?.setVariable(getVariableId(),viewModel)
        return BaseRVAdapter.Companion.BaseViewHolder(view, viewModel, mDataBinding!!)
    }

    @LayoutRes
    abstract fun getLayoutId():Int
    abstract fun getViewModel():VM
    abstract fun getVariableId():Int
}