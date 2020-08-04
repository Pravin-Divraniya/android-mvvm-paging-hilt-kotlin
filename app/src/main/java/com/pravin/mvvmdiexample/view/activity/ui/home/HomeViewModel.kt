package com.pravin.mvvmdiexample.view.activity.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.pravin.mvvmdiexample.data.repository.ItemRepository
import com.pravin.mvvmdiexample.paging.ItemPageSource

class HomeViewModel @ViewModelInject constructor(
	repository: ItemRepository
	) : ViewModel() {
	val flowRemoteAndDb = repository.getRemoteAndLocalFlow()
}