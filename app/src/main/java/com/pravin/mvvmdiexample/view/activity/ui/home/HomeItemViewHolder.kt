package com.pravin.mvvmdiexample.view.activity.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pravin.mvvmdiexample.data.model.Item
import com.pravin.mvvmdiexample.utils.getItemDashString
import com.pravin.mvvmdiexample.utils.getItemStatusDrawable
import kotlinx.android.synthetic.main.item.view.*

class HomeItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
	fun bind(item: Item){
		view.txt_item_name.text = item.name
		view.txt_item_status.text = item.status
		view.imv_item_status
			.setImageDrawable(view.context
				.getDrawable(getItemStatusDrawable(
					item.status)))
		view.txt_item_species.text = item.species
		view.txt_item_dash.text = getItemDashString(
			status = item.status,
			species = item.species)
		Glide.with(view)
			.load(item.image)
			.into(view.imv_item)
	}
}