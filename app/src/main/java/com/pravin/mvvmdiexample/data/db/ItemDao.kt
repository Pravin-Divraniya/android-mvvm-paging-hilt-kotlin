package com.pravin.mvvmdiexample.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pravin.mvvmdiexample.data.model.Item

@Dao
interface ItemDao {
	
	@Query("SELECT * FROM items")
	fun getAllItems():PagingSource<Int,Item>
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertAllItems(items:List<Item>)
	
	@Query("DELETE FROM items")
	suspend fun clearItems()
}