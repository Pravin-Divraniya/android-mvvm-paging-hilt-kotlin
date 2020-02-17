package com.pravin.mvvmdiexample.data.model.api

import com.google.gson.annotations.SerializedName
import com.pravin.mvvmdiexample.data.model.BaseModel

data class Photo(

	@field:SerializedName("albumId")
	val albumId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("thumbnailUrl")
	val thumbnailUrl: String? = null
) : BaseModel()