package com.ahclipse.ui.allRestaurants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahclipse.ui.R
import com.ahclipse.ui.injection.ViewModelFactory
import com.ahclipse.ui.presentation.GetRestaurantsViewModel
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

    private fun setupRestaurantsRecycler() {
        restaurants_recycler.layoutManager = LinearLayoutManager(this)
    }
}
