package com.pravin.mvvmdiexample.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.pravin.mvvmdiexample.data.db.AppDatabase
import com.pravin.mvvmdiexample.paging.ItemRemoteMediator
import javax.inject.Inject

class ItemRemoteDataSource @Inject constructor(
	private val appDatabase: AppDatabase,
	private val itemRemoteMediator: ItemRemoteMediator) : BaseDataSource {
	
	fun getRemoteAndLocalFlow() = Pager(
		config =  PagingConfig(5),
		remoteMediator = itemRemoteMediator
	){
		appDatabase.itemDao().getAllItems()
	}.flow
	
}