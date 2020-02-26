package com.pravin.mvvmdiexample.view.navigator

import android.view.View
import com.pravin.mvvmdiexample.data.model.BaseModel

/**
 * Created by Pravin Divraniya on 11/10/2017.
 */
interface PersonListNavigator : BaseNavigator{
    fun longClickedItem(item:BaseModel)
}
interface RemoteItemNavigator:BaseNavigator{
    fun onRemoteItemClick(item:BaseModel,view:View?)
}
