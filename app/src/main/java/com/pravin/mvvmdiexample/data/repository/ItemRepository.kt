package com.pravin.mvvmdiexample.data.repository

import com.pravin.mvvmdiexample.data.remote.ItemRemoteDataSource
import javax.inject.Inject

class ItemRepository @Inject constructor(
	private val itemRemoteDataSource: ItemRemoteDataSource):Repository{
	
	fun getRemoteAndLocalFlow() = itemRemoteDataSource.getRemoteAndLocalFlow()
}
