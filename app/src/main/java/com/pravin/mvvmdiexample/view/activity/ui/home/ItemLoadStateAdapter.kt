package com.pravin.mvvmdiexample.view.activity.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pravin.mvvmdiexample.R

class ItemLoadStateAdapter(private val retry: () -> Unit): LoadStateAdapter<ItemLoadStateViewHolder>() {
	override fun onBindViewHolder(holder: ItemLoadStateViewHolder, loadState: LoadState) {
		holder.bind(loadState)
	}
	
	override fun onCreateViewHolder(
		parent: ViewGroup,
		loadState: LoadState
	): ItemLoadStateViewHolder {
		val root = LayoutInflater.from(parent.context)
			.inflate(R.layout.load_state_item,parent,false)
		return ItemLoadStateViewHolder(root,retry)
	}
}

class ItemLoadStateViewHolder(view: View,
							  retry:()->Unit):
	RecyclerView.ViewHolder(view){
	private val progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
	private val retryBtn = view.findViewById<Button>(R.id.retry_button).apply {
		this.setOnClickListener { retry() }
	}
	private val error = view.findViewById<TextView>(R.id.error_msg)
	
	fun bind(loadState: LoadState){
		if(loadState is LoadState.Error){
			error.text = loadState.error.localizedMessage
		}
		
		progressBar.isVisible = loadState is LoadState.Loading
		retryBtn.isVisible = loadState is LoadState.Error
		error.isVisible = loadState is LoadState.Error
	}
}