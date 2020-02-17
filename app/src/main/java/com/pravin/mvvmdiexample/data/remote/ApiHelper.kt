package com.pravin.mvvmdiexample.data.remote

import com.androidnetworking.common.Priority
import com.pravin.mvvmdiexample.data.model.api.*
import com.pravin.mvvmdiexample.utils.ApiUtils
import com.pravin.mvvmdiexample.utils.ConstantData
import com.pravin.mvvmdiexample.utils.ConstantData.IMAGE_UPLOAD_URL
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import java.io.File
import javax.inject.Inject

/**
 * Created by Pravin Divraniya on 11/13/2017.
 */
class ApiHelper:IApiHelper {
    @Inject
    constructor()

    override fun getPhotos(): Observable<List<Photo>> = Rx2AndroidNetworking.get(ApiUtils.PHOTOS)
            .setPriority(Priority.MEDIUM)
            .build()
            .getObjectListObservable(Photo::class.java)

    override fun getAlbums(): Observable<List<Album>> = Rx2AndroidNetworking.get(ApiUtils.ALBUMS)
            .setPriority(Priority.HIGH)
            .build()
            .getObjectListObservable(Album::class.java)

    override fun getPosts(): Observable<List<Post>>  = Rx2AndroidNetworking.get(ApiUtils.POSTS)
            .setPriority(Priority.LOW)
            .build()
            .getObjectListObservable(Post::class.java)

    override fun getComments(): Observable<List<Comment>>  = Rx2AndroidNetworking.get(ApiUtils.COMMENTS)
            .setPriority(Priority.IMMEDIATE)
            .build()
            .getObjectListObservable(Comment::class.java)

    override fun getNews(apiKey:String) = Rx2AndroidNetworking.get(ConstantData.NEWS_BASE_URL)
                .addQueryParameter("sources","google-news")
                .addQueryParameter("apiKey",apiKey)
                .setPriority(Priority.MEDIUM)
                .build()
                .getObjectObservable(NewsResponse::class.java)

    override fun uploadImageToServer(fileMap: MutableMap<String, File>,
                                     params: MutableMap<String, Any>): Flowable<ImageUploadResponse> =

            Rx2AndroidNetworking.upload(IMAGE_UPLOAD_URL)
                    .addMultipartFile(fileMap)
                    .addMultipartParameter(params)
                    .setTag("Test")
                    .setPriority(Priority.HIGH)
                    .build()
                    .setUploadProgressListener { _, _ -> }//Use these both objects of type Long in order to calculate and show the progress.
                    .getObjectObservable(ImageUploadResponse::class.java)
                    .toFlowable(BackpressureStrategy.BUFFER)
}