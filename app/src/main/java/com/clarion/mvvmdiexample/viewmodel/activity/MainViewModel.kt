package com.clarion.mvvmdiexample.viewmodel.activity

import android.databinding.Bindable
import com.clarion.mvvmdiexample.BR
import com.clarion.mvvmdiexample.data.model.manager.DataManager
import com.clarion.mvvmdiexample.view.navigator.MainActivityNavigator
import com.clarion.mvvmdiexample.viewmodel.base.BaseViewModel
import java.io.Serializable

/**
 * Created by Pravin Divraniya on 11/20/2017.
 */
class MainViewModel(dataManager: DataManager):
        BaseViewModel<MainActivityNavigator>(dataManager),Serializable{

    private var frgTitle = ""

    @Bindable
    fun getFrgTitle() = frgTitle

    fun setFrgTitle(value:String){
        frgTitle = value
        notifyPropertyChanged(BR.frgTitle)
    }
}