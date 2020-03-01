package com.pravin.mvvmdiexample.di.builder

import com.pravin.mvvmdiexample.di.module.PagerActivityModule
import com.pravin.mvvmdiexample.di.module.PersonListActivityModule
import com.pravin.mvvmdiexample.di.module.provider.*
import com.pravin.mvvmdiexample.view.activity.AddPersonActivity
import com.pravin.mvvmdiexample.view.activity.MainActivity
import com.pravin.mvvmdiexample.view.activity.PagerActivity
import com.pravin.mvvmdiexample.view.activity.PersonListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
@Module
interface ActivityBuilder {
	
    @ContributesAndroidInjector(modules = [(RemoteDataFrgProvider::class),
        (GalleryFrgProvider::class),(MainFrgProvider::class)])
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindAddPersonActivity(): AddPersonActivity

    @ContributesAndroidInjector(modules = [(PersonListActivityModule::class), (MyDialogFrgProvider::class)])
    fun bindPersonListActivity(): PersonListActivity

    @ContributesAndroidInjector(modules = [(PagerActivityModule::class), (PageFrgProvider::class)])
    fun bindPagerActivity():PagerActivity
}