package com.clarion.mvvmdiexample.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.clarion.mvvmdiexample.app.MyApplication
import com.clarion.mvvmdiexample.data.local.db.AppDatabase
import com.clarion.mvvmdiexample.data.local.db.DbHelper
import com.clarion.mvvmdiexample.data.local.db.IDbHelper
import com.clarion.mvvmdiexample.data.local.db.prefs.ISharedPrefsHelper
import com.clarion.mvvmdiexample.data.local.db.prefs.SharedPrefsHelper
import com.clarion.mvvmdiexample.data.remote.ApiHelper
import com.clarion.mvvmdiexample.data.remote.IApiHelper
import com.clarion.mvvmdiexample.di.annotation.DatabaseInfo
import com.clarion.mvvmdiexample.di.annotation.PreferenceInfo
import com.clarion.mvvmdiexample.utils.ConstantData.DB_NAME
import com.clarion.mvvmdiexample.utils.ConstantData.DB_VERSION
import com.clarion.mvvmdiexample.utils.ConstantData.SHARED_PREF_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
@Module
class AppModule() {
    @Singleton
    @Provides
    fun provideContext(application: MyApplication):Context = application

    @DatabaseInfo
    @Provides
    fun provideDatabaseName() = DB_NAME

    @DatabaseInfo
    @Provides
    fun provideDatabaseVersion() = DB_VERSION

    @PreferenceInfo
    @Provides
    fun providePrefName() = SHARED_PREF_NAME

    @Singleton
    @Provides
    fun provideAppDatabase(context:Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideDbHelper(appDbHelper: DbHelper): IDbHelper = appDbHelper

    @Singleton
    @Provides
    fun providePreferencesHelper(appPreferencesHelper: SharedPrefsHelper): ISharedPrefsHelper
            = appPreferencesHelper

    @Singleton
    @Provides
    fun provideSharedPrefs(context:Context) =
            context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)!!

    @Singleton
    @Provides
    fun provideApiHelper(apiHelper: ApiHelper):IApiHelper = apiHelper
}