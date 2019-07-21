package com.ahclipse.ui.allRestaurants

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahclipse.ui.R
import com.ahclipse.ui.injection.ViewModelFactory
import com.ahclipse.ui.presentation.GetRestaurantsViewModel
import com.ahclipse.ui.presentation.model.RestaurantView
import com.ahclipse.ui.presentation.state.Resource
import com.ahclipse.ui.presentation.state.ResourceState
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_all_restaurants.*
import javax.inject.Inject

class AllRestaurantsActivity : AppCompatActivity() {

    @Inject
    lateinit var allRestaurantsAdapter: AllRestaurantsAdapter
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var getRestaurantsViewModel: GetRestaurantsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_restaurants)
        AndroidInjection.inject(this)

        getRestaurantsViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(GetRestaurantsViewModel::class.java)

        setupRestaurantsRecycler()
    }

    override fun onStart() {
        super.onStart()
        getRestaurantsViewModel.getRestaurants().observe(this,
            Observer<Resource<List<RestaurantView>>> {
                it?.let {
                    handleDataState(it)
                }
            })
        getRestaurantsViewModel.fetchRestaurants()
    }

    private fun setupRestaurantsRecycler() {
        restaurants_recycler.layoutManager = LinearLayoutManager(this)
        restaurants_recycler.adapter = allRestaurantsAdapter
    }

    private fun handleDataState(resource: Resource<List<RestaurantView>>) {
        when (resource.status) {
            ResourceState.SUCCESS -> {
                setupScreenForSuccess(resource.data)
            }
            ResourceState.LOADING -> {
                restaurants_progress.visibility = View.VISIBLE
                restaurants_recycler.visibility = View.GONE
            }
            // Error
            else -> {
                restaurants_progress.visibility = View.GONE
            }
        }
    }

    private fun setupScreenForSuccess(restaurants: List<RestaurantView>?) {
        restaurants_progress.visibility = View.GONE
        restaurants_recycler.visibility = View.VISIBLE
        restaurants?.let {
            allRestaurantsAdapter.restaurants = it
            allRestaurantsAdapter.notifyDataSetChanged()
        }
    }
}
