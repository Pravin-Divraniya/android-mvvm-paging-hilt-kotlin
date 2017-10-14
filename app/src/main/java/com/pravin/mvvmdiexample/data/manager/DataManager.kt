package com.pravin.mvvmdiexample.data.model.manager

import android.content.Context
import com.pravin.mvvmdiexample.data.db.IDbHelper
import com.pravin.mvvmdiexample.data.prefs.SharedPrefsHelper
import com.pravin.mvvmdiexample.data.model.Person
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Pravin Divraniya on 10/5/2017.
 */
@Singleton
class DataManager: IDbHelper {
    val context:Context
    val mSharedPrefsHelper: SharedPrefsHelper
    val dbHelper: IDbHelper

    @Inject
    constructor(context:Context,
                dbHelper: IDbHelper,
                sharedPreHelper: SharedPrefsHelper){
        this.context = context
        this.mSharedPrefsHelper = sharedPreHelper
        this.dbHelper = dbHelper
    }

    fun saveAccessToken(accessToken: String) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken)
    }

    fun getAccessToken() = mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN,null)

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
}