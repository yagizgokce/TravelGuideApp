package com.yagizgokce.travelguideapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
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
        //openFragment(homeFragment)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->openFragment(homeFragment)
                R.id.search->openFragment(searchFragment)
                R.id.plan->openFragment(tripPlanFragment)
                R.id.guide->openFragment(guideFragment)

            }
            true
        }
        navController= Navigation.findNavController(this,R.id.fragment)
        setupWithNavController(binding.bottomNavigation,navController)*/
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

    }

    fun openFragment(fragment: Fragment?) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment, fragment!!)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}