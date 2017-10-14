package com.pravin.mvvmdiexample.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.pravin.mvvmdiexample.utils.ConstantData.Companion.DB_NAME
import com.pravin.mvvmdiexample.utils.ConstantData.Companion.DB_VERSION
import com.pravin.mvvmdiexample.utils.ConstantData.Companion.SHARED_PREF_NAME
import com.pravin.mvvmdiexample.data.db.DbHelper
import com.pravin.mvvmdiexample.data.db.IDbHelper
import com.pravin.mvvmdiexample.data.db.AppDatabase
import com.pravin.mvvmdiexample.data.prefs.ISharedPrefsHelper
import com.pravin.mvvmdiexample.di.annotation.DatabaseInfo
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
    fun provideContext(application: Application):Context = application

    @DatabaseInfo
    @Provides
    fun provideDatabaseName() = DB_NAME

    @DatabaseInfo
    @Provides
    fun provideDatabaseVersion() = DB_VERSION

    @Singleton
    @Provides
    fun provideAppDatabase(context:Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideDbHelper(appDbHelper: DbHelper): IDbHelper = appDbHelper

    @Singleton
    @Provides
    fun providePreferencesHelper(appPreferencesHelper: ISharedPrefsHelper):
            ISharedPrefsHelper = appPreferencesHelper

    @Provides
    fun provideSharedPrefs(context:Context) =
            context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
}