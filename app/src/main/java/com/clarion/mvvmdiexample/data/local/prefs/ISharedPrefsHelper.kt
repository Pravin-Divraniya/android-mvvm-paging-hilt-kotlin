package com.clarion.mvvmdiexample.data.local.db.prefs

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
interface ISharedPrefsHelper {
    fun getCurrentUserId(): String?

    fun setCurrentUserId(userId: String?)

    fun getCurrentUserName(): String

    fun setCurrentUserName(userName: String)

    fun getCurrentUserEmail(): String

    fun setCurrentUserEmail(email: String)

    fun getCurrentUserProfilePicUrl(): String

    fun setCurrentUserProfilePicUrl(profilePicUrl: String)

    fun getAccessToken(): String

    fun setAccessToken(accessToken: String)
}