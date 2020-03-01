package com.pravin.mvvmdiexample.viewmodel.list

import android.view.View
import androidx.databinding.Bindable
import com.pravin.mvvmdiexample.data.model.BaseModel
import com.pravin.mvvmdiexample.data.model.api.Articles
import com.pravin.mvvmdiexample.data.model.api.Photo
import com.pravin.mvvmdiexample.di.annotation.ActivityContext
import com.pravin.mvvmdiexample.view.navigator.RemoteItemNavigator
import com.pravin.mvvmdiexample.viewmodel.base.ListItemViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */

@ActivityContext
class RemoteItemViewModel : ListItemViewModel<BaseModel>() {

    private lateinit var item: BaseModel

    override fun setItem(item: BaseModel) {
        this.item = item
        notifyChange()
    }

    override fun getItem(): BaseModel = item

    @Bindable
    fun getTitle():String?{
        return when(item){
            is Photo -> (item as Photo).title!!
            is Articles -> (item as Articles).title
            else ->{
                ""
            }
        }
    }

    @Bindable
    fun getThumbImageUrl():String?{
        return when(item){
            is Photo -> (item as Photo).thumbnailUrl!!
            is Articles -> (item as Articles).urlToImage
            else ->{
                ""
            }
        }
    }

    fun onItemClick(): View.OnClickListener{
        return View.OnClickListener { p0 -> (getNavigator() as RemoteItemNavigator).onRemoteItemClick(item,p0) }
    }
}