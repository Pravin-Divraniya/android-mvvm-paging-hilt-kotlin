package com.clarion.mvvmdiexample.view.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clarion.mvvmdiexample.viewmodel.base.ListItemViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
abstract class BaseRVAdapter<BM,VM:ListItemViewModel<BM>>(private val datas: MutableList<BM>):
        RecyclerView.Adapter<BaseRVAdapter.Companion.BaseViewHolder<BM,VM>>(){

    override fun getItemCount() = datas.count()

    override fun onBindViewHolder(holder: BaseViewHolder<BM,VM>, position: Int) {
        holder.setItem(datas[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BM,VM> {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutId(),parent,false)
        val mDataBinding = DataBindingUtil.bind<ViewDataBinding>(view)
        val viewModel = getViewModel()
        mDataBinding?.setVariable(getVariableId(),viewModel)
        return BaseViewHolder(view,viewModel,mDataBinding!!)
    }
    @LayoutRes
    abstract fun getLayoutId():Int
    abstract fun getViewModel():VM
    abstract fun getVariableId():Int

    fun addAll(datas:List<BM>){
        this.datas.addAll(datas)
        notifyDataSetChanged()
    }
    fun add(type:BM){
        this.datas.add(type)
        notifyItemInserted(this.datas.size-1)
        notifyDataSetChanged()
    }
    fun removeAll(){
        this.datas.clear()
        notifyDataSetChanged()
    }
    fun remove(type:BM){
        val position = this.datas.indexOf(type)
        this.datas.remove(type)
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }
    fun change(newItem:BM,oldItem:BM){
        val position = this.datas.indexOf(oldItem)
        this.datas.set(position,newItem)
        notifyItemChanged(position)
        notifyDataSetChanged()
    }

    companion object {
        class BaseViewHolder<Type,VM: ListItemViewModel<Type>>
                (view:View,viewModel:VM,mDataBinding:ViewDataBinding): RecyclerView.ViewHolder(view) {
            private val mDataBinding:ViewDataBinding = mDataBinding
            private val mViewModel:VM = viewModel
            fun setItem(item:Type){
                mViewModel.setItem(item)
                mDataBinding.executePendingBindings()
            }
        }
    }
}