package com.example.assesmentapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.assesmentapplication.MainApplication
import com.example.assesmentapplication.R
import com.example.assesmentapplication.databinding.ActivityMain1Binding
import com.example.assesmentapplication.di.component.DaggerActivityComponent
import com.example.assesmentapplication.di.module.ActivityModule
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()

        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_popular,
                R.id.navigation_toprated,
                R.id.navigation_upcoming
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent
            .builder()
            .applicationComponent((application as MainApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)
    }
}