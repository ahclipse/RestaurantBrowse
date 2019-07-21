package com.ahclipse.ui.allRestaurants

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ahclipse.ui.R
import com.ahclipse.ui.presentation.model.RestaurantView
import javax.inject.Inject

class AllRestaurantsAdapter @Inject constructor() : RecyclerView.Adapter<AllRestaurantsAdapter.ViewHolder>() {

    var restaurants: List<RestaurantView> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return restaurants.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.restaurantName.text = restaurant.name
        holder.restaurantDescription.text = restaurant.description
        holder.restaurantStatus.text = restaurant.status

//        Glide.with(holder.itemView.context)
//            .load(project.ownerAvatar)
//            .apply(RequestOptions.circleCropTransform())
//            .into(holder.restaurantImg)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var restaurantImg: ImageView = view.findViewById(R.id.restaurant_img)
        var restaurantName: TextView = view.findViewById(R.id.restaurant_name)
        var restaurantDescription: TextView = view.findViewById(R.id.restaurant_description)
        var restaurantStatus: TextView = view.findViewById(R.id.restaurant_status)
    }
}