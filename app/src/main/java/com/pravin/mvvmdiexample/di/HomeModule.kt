package com.pravin.mvvmdiexample.di

import com.pravin.mvvmdiexample.data.db.AppDatabase
import com.pravin.mvvmdiexample.data.remote.HomeItemService
import com.pravin.mvvmdiexample.data.remote.ItemRemoteDataSource
import com.pravin.mvvmdiexample.data.repository.ItemRepository
import com.pravin.mvvmdiexample.paging.ItemPageSource
import com.pravin.mvvmdiexample.paging.ItemRemoteMediator
import com.pravin.mvvmdiexample.view.activity.ui.home.HomePageAdapter
import com.pravin.mvvmdiexample.view.activity.ui.home.ItemComparator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object HomeModule {

	@Provides
	fun provideHomeItemService(retrofit: Retrofit): HomeItemService =
		retrofit.create(HomeItemService::class.java)
	
	@Provides
	fun provideItemRemoteMediator(appDatabase: AppDatabase,homeItemService:HomeItemService) =
		ItemRemoteMediator(appDatabase,homeItemService)
	
	@Provides
	fun provideRemoteItemDataSource(appDatabase: AppDatabase,itemRemoteMediator: ItemRemoteMediator) =
		ItemRemoteDataSource(appDatabase,itemRemoteMediator)
	
	@Provides
	fun provideItemRepository(itemRemoteDataSource: ItemRemoteDataSource) =
		ItemRepository(itemRemoteDataSource)
	
	@Provides
	fun provideItemPageSource(homeItemService: HomeItemService) =
		ItemPageSource(homeItemService)
	
	@Provides
	fun provideHomePageAdapter() =
		HomePageAdapter(ItemComparator)
}