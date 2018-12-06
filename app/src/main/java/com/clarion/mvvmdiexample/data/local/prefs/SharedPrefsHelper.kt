package com.clarion.mvvmdiexample.data.local.db.prefs

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Pravin Divraniya on 10/5/2017.
 */
@Singleton
class SharedPrefsHelper: ISharedPrefsHelper {

    companion object {
        private val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }
    val mSharedPreferences: SharedPreferences

    @Inject
    constructor(mSharedPreferences: SharedPreferences){
        this.mSharedPreferences = mSharedPreferences
    }

    override fun getCurrentUserId() = mSharedPreferences.getString(PREF_KEY_CURRENT_USER_ID,null)

    override fun setCurrentUserId(userId: String?) {
        mSharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_ID,userId)
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

    override fun getAccessToken() = mSharedPreferences.getString(PREF_KEY_ACCESS_TOKEN,null)

    override fun setAccessToken(accessToken: String) {
        mSharedPreferences.edit().putString(PREF_KEY_ACCESS_TOKEN,accessToken)
    }
}