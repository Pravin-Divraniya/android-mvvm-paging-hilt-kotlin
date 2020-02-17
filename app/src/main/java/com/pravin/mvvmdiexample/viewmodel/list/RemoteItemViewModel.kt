package com.pravin.mvvmdiexample.viewmodel.list

import android.view.View
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.pravin.mvvmdiexample.R
import com.pravin.mvvmdiexample.data.model.BaseModel
import com.pravin.mvvmdiexample.data.model.api.Articles
import com.pravin.mvvmdiexample.data.model.api.Photo
import com.pravin.mvvmdiexample.utils.defaultRequest
import com.pravin.mvvmdiexample.view.navigator.RemoteItemNavigator
import com.pravin.mvvmdiexample.viewmodel.base.ListItemViewModel

/**
 * Created by Pravin Divraniya on 10/10/2017.
 */
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

    fun getUrl():String?{
        when(item){
            is Photo -> return (item as Photo).url!!
            is Articles -> return (item as Articles).url
            else ->{
                return ""
            }
        }
    }

    @Bindable
    fun getThumbImageUrl():String?{
        when(item){
            is Photo -> return (item as Photo).thumbnailUrl!!
            is Articles -> return (item as Articles).urlToImage
            else ->{
                return ""
            }
        }
    }

    fun onItemClick(): View.OnClickListener{
        return View.OnClickListener { p0 -> (getNavigator() as RemoteItemNavigator).onRemoteItemClick(item,p0) }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("bind:imageUrl")
        fun loadImages(view:ImageView,url:String){
            Glide.with(view)
                    .setDefaultRequestOptions(defaultRequest(R.drawable.placeholder, R.drawable.noimageplaceholder))
                    .load(url)
                    .thumbnail(0.2F)
                    .into(view)
        }
    }
}