package com.clarion.mvvmdiexample.view.adapter

import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.R
import com.clarion.mvvmdiexample.data.model.BaseModel
import com.clarion.mvvmdiexample.view.navigator.RemoteItemNavigator
import com.clarion.mvvmdiexample.viewmodel.list.RemoteItemViewModel

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
