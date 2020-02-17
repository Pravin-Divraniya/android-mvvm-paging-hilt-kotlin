package com.pravin.mvvmdiexample.view.adapter

import com.pravin.mvvmdiexample.BR
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.BaseModel
import com.pravin.mvvmdiexample.view.navigator.RemoteItemNavigator
import com.pravin.mvvmdiexample.viewmodel.list.RemoteItemViewModel

/**
 * [RecyclerView.Adapter] that can display a [Photo].
 */
/**
 * Created by Pravin Divraniya
 */
class RemoteDataAdapter(mValues: MutableList<BaseModel>,listNavigator: RemoteItemNavigator) :
        BaseRVAdapter<BaseModel, RemoteItemViewModel>(mValues) {
    private val navigator = listNavigator

    override fun getVariableId() = BR.remoteItemVM

    override fun getLayoutId() = R.layout.frg_remotedata_list

    override fun getViewModel(): RemoteItemViewModel {
        val mViewModel = RemoteItemViewModel()
        mViewModel.setNavigator(navigator)
        return mViewModel
    }
}
