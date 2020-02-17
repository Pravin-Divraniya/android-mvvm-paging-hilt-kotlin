package com.pravin.mvvmdiexample.data.model.api

import com.google.gson.annotations.SerializedName
import com.pravin.mvvmdiexample.data.model.BaseModel

data class Comment(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("postId")
	val postId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("email")
	val email: String? = null
):BaseModel()