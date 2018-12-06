package com.clarion.mvvmdiexample.di.builder

import com.clarion.mvvmdiexample.di.module.AddPersonActivityModule
import com.clarion.mvvmdiexample.di.module.MainActivityModule
import com.clarion.mvvmdiexample.di.module.PagerActivityModule
import com.clarion.mvvmdiexample.di.module.PersonListActivityModule
import com.clarion.mvvmdiexample.di.module.provider.*
import com.clarion.mvvmdiexample.view.activity.AddPersonActivity
import com.clarion.mvvmdiexample.view.activity.MainActivity
import com.clarion.mvvmdiexample.view.activity.PagerActivity
import com.clarion.mvvmdiexample.view.activity.PersonListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Pravin Divraniya on 10/6/2017.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (RemoteDataFrgProvider::class),
        (GalleryFrgProvider::class),(MainFrgProvider::class)])
    abstract fun bindMainActivity():MainActivity

    @ContributesAndroidInjector(modules = [(AddPersonActivityModule::class)])
    abstract fun bindAddPersonActivity(): AddPersonActivity

    @ContributesAndroidInjector(modules = [(PersonListActivityModule::class), (MyDialogFrgProvider::class)])
    abstract fun bindPersonListActivity(): PersonListActivity

    @ContributesAndroidInjector(modules = [(PagerActivityModule::class), (PageFrgProvider::class)])
    abstract fun bindPagerActivity():PagerActivity
}