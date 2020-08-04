package com.pravin.mvvmdiexample.view.activity.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pravin.mvvmdiexample.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
	
	private var mContext: Context? = null
	private lateinit var pageRecyclerView:RecyclerView
	private val homeViewModel: HomeViewModel by viewModels()
	@Inject lateinit var homePageAdapter:HomePageAdapter
	
	override fun onAttach(context: Context) {
		super.onAttach(context)
		mContext = context
	}
	
	override fun onDetach() {
		super.onDetach()
		mContext = null
	}
	
	@ExperimentalCoroutinesApi
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		var root:View? = null
		
		try {
			root = inflater.inflate(R.layout.fragment_home, container, false)
			
			pageRecyclerView = root.findViewById(R.id.rcv_items)
			pageRecyclerView.layoutManager = LinearLayoutManager(mContext)
			
			setPagerAdapter()
			
			getData()
			
		}catch (e:Throwable){
			e.printStackTrace()
		}
		return root
	}
	
	@ExperimentalCoroutinesApi
	private fun getData(){
		lifecycleScope.launch {
			homeViewModel.flowRemoteAndDb.collectLatest { pagingData ->
				homePageAdapter.submitData(pagingData)
			}
		}
	}
	
	@ExperimentalCoroutinesApi
	private fun setPagerAdapter() {
		pageRecyclerView.adapter = homePageAdapter.run {
			withLoadStateFooter(
				footer = ItemLoadStateAdapter { retry() }
			)
		}
	}
	
}