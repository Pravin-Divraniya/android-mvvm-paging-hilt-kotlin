package com.pravin.mvvmdiexample.view.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.viewmodel.base.ListItemViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
abstract class BaseRVAdapter<MODELType,VM:ListItemViewModel<MODELType>>
        (datas:List<MODELType>): RecyclerView.Adapter<BaseRVAdapter.Companion.BaseViewHolder<MODELType,VM>>() {

    private val datas:List<MODELType>
    private lateinit var view:View
    init {
        this.datas = datas
    }

    override fun getItemCount() = datas.count()

    override fun onBindViewHolder(holder: BaseViewHolder<MODELType,VM>?, position: Int) {
        holder!!.setItem(datas[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<MODELType,VM> {
        view = LayoutInflater.from(parent!!.context).inflate(getLayoutId(),parent,false)
        val mDataBinding = DataBindingUtil.bind<ViewDataBinding>(view)
        val viewModel = getViewModel()
        mDataBinding.setVariable(BR.viewmodel,viewModel)
        return BaseViewHolder<MODELType,VM>(view,viewModel,mDataBinding)
    }
    @LayoutRes
    abstract fun getLayoutId():Int
    abstract fun getViewModel():VM

    fun getView() = view

    companion object {
        open class BaseViewHolder<Type,VM: ListItemViewModel<Type>>
                (view:View,viewModel:VM,mDataBinding:ViewDataBinding): RecyclerView.ViewHolder(view) {
            private val mDataBinding:ViewDataBinding
            private val mViewModel:VM
            init {
                this.mDataBinding = mDataBinding
                this.mViewModel = viewModel
            }
            fun setItem(item:Type){
                mViewModel.setItem(item)
                mDataBinding.executePendingBindings()
            }
        }
    }
}