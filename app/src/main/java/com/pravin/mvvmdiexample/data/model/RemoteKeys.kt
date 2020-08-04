package com.pravin.mvvmdiexample.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeys(
	@PrimaryKey
	val id: Int?,
	val next:Int?,
	val prev:Int?
)