package com.pravin.mvvmdiexample.paging

import android.util.Log
import androidx.paging.PagingSource
import com.pravin.mvvmdiexample.data.model.Item
import com.pravin.mvvmdiexample.data.remote.HomeItemService

class ItemPageSource(
	private val homeItemService: HomeItemService): PagingSource<Int, Item>() {
	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
		try {
			val page = params.key?:1
			val response = homeItemService.getAllItems(page)
			
			val next = response.body()?.info?.next
			val nextPage = next?.split("page=")?.get(1)?.toIntOrNull()
			val prev:String? = response.body()?.info?.prev
			val prevPage = prev?.split("page=")?.get(1)?.toIntOrNull()
			
			val result:List<Item> = response.body()?.results.run { this as List<Item> }
			
			return LoadResult.Page(
				data = result,
				prevKey = prevPage,
				nextKey = nextPage
			)
		}catch (e:Throwable){
			Log.e("Error","Item Page Source",e)
			return LoadResult.Error(e)
		}
	}
}