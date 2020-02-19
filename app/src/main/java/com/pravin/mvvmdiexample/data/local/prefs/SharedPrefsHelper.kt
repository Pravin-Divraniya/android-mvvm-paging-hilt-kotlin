package com.pravin.mvvmdiexample.data.local.db.prefs

import android.annotation.SuppressLint
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Pravin Divraniya on 10/5/2017.
 */
@Singleton
class SharedPrefsHelper @Inject constructor(private val mSharedPreferences: SharedPreferences) : ISharedPrefsHelper {

    companion object {
        private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
    }
    
    override fun getCurrentUserId() = mSharedPreferences.getString(PREF_KEY_CURRENT_USER_ID,null)

    override fun setCurrentUserId(userId: String?) {
        mSharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_ID,userId).apply()
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
        mSharedPreferences.edit().putString(PREF_KEY_ACCESS_TOKEN,accessToken).apply()
    }
}