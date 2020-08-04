package com.pravin.mvvmdiexample.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
	val created: String,
	val gender: String,
	@PrimaryKey
	val id: Int,
	val image: String,
	val name: String,
	val species: String,
	val status: String,
	val type: String,
	val url: String,//#919095
	@Embedded val origin:Origin,
	@Embedded val location: Location,
	@Embedded val episode:ArrayList<String>?
)

data class Origin(
	@ColumnInfo(name = "origin_name") val name:String,
	@ColumnInfo(name = "origin_url")val url:String
)

data class Location(
	@ColumnInfo(name = "location_name") val name:String,
	@ColumnInfo(name = "location_url") val url:String
)