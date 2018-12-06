package com.clarion.mvvmdiexample.data.model.api

import com.google.gson.annotations.SerializedName
import com.clarion.mvvmdiexample.data.model.BaseModel

data class Album(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
):BaseModel()