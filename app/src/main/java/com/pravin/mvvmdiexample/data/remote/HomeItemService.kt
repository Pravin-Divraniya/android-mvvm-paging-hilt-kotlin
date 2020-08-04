package com.pravin.mvvmdiexample.data.remote

import com.pravin.mvvmdiexample.data.model.ItemList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeItemService {
	
	@GET("character/")
	suspend fun getAllItems(@Query("page")page:Int):Response<ItemList>
}