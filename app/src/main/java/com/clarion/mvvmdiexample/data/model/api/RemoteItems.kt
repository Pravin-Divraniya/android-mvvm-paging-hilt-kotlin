package com.clarion.mvvmdiexample.data.model.api

import com.clarion.mvvmdiexample.data.model.BaseModel
import com.google.gson.annotations.SerializedName

/**
 * Created by Pravin Divraniya on 11/27/2017.
 */
data class Articles(val title:String,
                    @SerializedName("description")
                    val desc:String,
                    val url:String,
                    val author:String,
                    val urlToImage:String,
                    val publishedAt:String):BaseModel()

data class NewsResponse(val status:String,
                        val articles: List<Articles>): BaseModel()

data class GalleryImages(val id:Short,
                        var url:String):BaseModel(){
    var isChecked:Boolean = false
}