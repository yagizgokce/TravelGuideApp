package com.yagizgokce.travelguideapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.yagizgokce.travelguideapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/*private val homeFragment= HomeFragment()
private val searchFragment= SearchFragment()
private val tripPlanFragment= TripPlanFragment()
private val guideFragment= GuideFragment()*/

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id != R.id.detailFragment) {
                binding.bottomNavigation.visibility = View.VISIBLE
            } else {
                binding.bottomNavigation.visibility = View.GONE
            }
        }

    }

}