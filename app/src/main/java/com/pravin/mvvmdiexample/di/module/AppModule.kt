package com.pravin.mvvmdiexample.di.module

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.pravin.mvvmdiexample.app.MyApplication
import com.pravin.mvvmdiexample.data.local.db.AppDatabase
import com.pravin.mvvmdiexample.data.local.db.DbHelper
import com.pravin.mvvmdiexample.data.local.db.IDbHelper
import com.pravin.mvvmdiexample.data.local.db.prefs.ISharedPrefsHelper
import com.pravin.mvvmdiexample.data.local.db.prefs.SharedPrefsHelper
import com.pravin.mvvmdiexample.data.remote.ApiHelper
import com.pravin.mvvmdiexample.data.remote.IApiHelper
import com.pravin.mvvmdiexample.utils.ConstantData.DB_NAME
import com.pravin.mvvmdiexample.utils.ConstantData.DB_VERSION
import com.pravin.mvvmdiexample.utils.ConstantData.SHARED_PREF_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pravin Divraniya on 10/3/2017.
 */
@Module
class AppModule {
    @Singleton
    @Provides
    fun provideContext(application: MyApplication):Context = application

    @Singleton
    @Provides
    fun provideDatabaseName() = DB_NAME

    @Singleton
    @Provides
    fun provideDatabaseVersion() = DB_VERSION

    @Singleton
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
    fun provideSharedPrefs(context:Context): SharedPreferences =
            context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideApiHelper(apiHelper: ApiHelper):IApiHelper = apiHelper
}