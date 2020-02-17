package com.pravin.mvvmdiexample.data.model.manager

import android.content.Context
import com.pravin.mvvmdiexample.data.local.db.DbHelper
import com.pravin.mvvmdiexample.data.local.db.IDbHelper
import com.pravin.mvvmdiexample.data.local.db.prefs.ISharedPrefsHelper
import com.pravin.mvvmdiexample.data.local.db.prefs.SharedPrefsHelper
import com.pravin.mvvmdiexample.data.manager.IDataManager
import com.pravin.mvvmdiexample.data.model.api.*
import com.pravin.mvvmdiexample.data.model.db.Person
import com.pravin.mvvmdiexample.data.remote.ApiHelper
import com.pravin.mvvmdiexample.data.remote.IApiHelper
import io.reactivex.Flowable
import io.reactivex.Observable
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Pravin Divraniya on 10/5/2017.
 */
@Singleton
class DataManager: IDataManager {
    private val context:Context
    private val mSharedPrefsHelper: SharedPrefsHelper
    private val dbHelper: DbHelper
    private val apiHelper: ApiHelper

    @Inject
    constructor(context:Context,
                dbHelper: IDbHelper,
                sharedPreHelper: ISharedPrefsHelper,
                apiHelper: IApiHelper){
        this.context = context
        this.mSharedPrefsHelper = sharedPreHelper as SharedPrefsHelper
        this.dbHelper = dbHelper as DbHelper
        this.apiHelper = apiHelper as ApiHelper
    }


    override fun setAccessToken(accessToken: String) {
        mSharedPrefsHelper.setAccessToken(accessToken)
    }
    override fun getAccessToken() = mSharedPrefsHelper.getAccessToken()

    override fun getCurrentUserId(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserId(userId: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserName(userName: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserEmail(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserEmail(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCurrentUserProfilePicUrl(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCurrentUserProfilePicUrl(profilePicUrl: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllPerson(): List<Person> = dbHelper.getAllPerson()

    override fun insertPerson(person: Person) {
        dbHelper.insertPerson(person)
    }

    override fun updatePerson(person: Person) {
        dbHelper.updatePerson(person)
    }

    override fun deletePerson(person: Person) {
        dbHelper.deletePerson(person)
    }

    override fun getPerson(id: Long): Person = dbHelper.getPerson(id)

    override fun getNews(apiKey:String): Observable<NewsResponse> = apiHelper.getNews(apiKey)

    override fun getPhotos(): Observable<List<Photo>> = apiHelper.getPhotos()

    override fun getAlbums(): Observable<List<Album>> = apiHelper.getAlbums()

    override fun getPosts(): Observable<List<Post>> = apiHelper.getPosts()

    override fun getComments(): Observable<List<Comment>> = apiHelper.getComments()

    override fun uploadImageToServer(fileMap: MutableMap<String, File>,
                                     params: MutableMap<String, Any>):
            Flowable<ImageUploadResponse> = apiHelper.uploadImageToServer(fileMap, params)
}