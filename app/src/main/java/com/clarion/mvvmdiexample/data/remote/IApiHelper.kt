package com.clarion.mvvmdiexample.data.remote

import com.clarion.mvvmdiexample.data.model.api.*
import io.reactivex.Flowable
import io.reactivex.Observable
import java.io.File

/**
 * Created by Pravin Divraniya on 11/13/2017.
 */
interface IApiHelper {
    fun getNews(apiKey:String):Observable<NewsResponse>
    fun getPhotos():Observable<List<Photo>>
    fun getAlbums():Observable<List<Album>>
    fun getPosts():Observable<List<Post>>
    fun getComments():Observable<List<Comment>>
    fun uploadImageToServer(fileMap:MutableMap<String, File>,
                            params:MutableMap<String,Any>): Flowable<ImageUploadResponse>
}