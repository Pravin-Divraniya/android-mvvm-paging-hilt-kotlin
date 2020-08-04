package com.pravin.mvvmdiexample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pravin.mvvmdiexample.data.model.RemoteKeys

@Dao
interface RemoteKeysDao{
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertAll(remoteKeys: List<RemoteKeys>)
	
	@Query("SELECT * FROM remote_keys WHERE id = :id")
	suspend fun remoteKeysId(id:Int):RemoteKeys?
	
	@Query("DELETE FROM remote_keys")
	suspend fun clearKeys()
}