package com.miguelrr.capsshop.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.miguelrr.capsshop.R
import com.miguelrr.capsshop.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_search,
                R.id.navigation_account,
                R.id.navigation_help
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val fab : FloatingActionButton = findViewById(R.id.fab_sc)
        fab.setOnClickListener{
            navController.navigate(R.id.navigation_shopping_car)
        }

        navController.addOnDestinationChangedListener{_, destination, _ ->
            if(destination.id == R.id.navigation_login ||
                destination.id == R.id.navigation_pay ||
                destination.id == R.id.navigation_selected_product ||
                destination.id == R.id.navigation_shopping_car ||
                destination.id == R.id.navigation_signup){

                fab.visibility = View.GONE
                navView.visibility = View.GONE
            }else{
                fab.visibility = View.VISIBLE
                navView.visibility = View.VISIBLE
            }
        }


    }
}