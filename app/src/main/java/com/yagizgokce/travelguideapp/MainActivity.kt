package com.yagizgokce.travelguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.yagizgokce.travelguideapp.databinding.ActivityMainBinding
import com.yagizgokce.travelguideapp.presentation.guide.ui.GuideFragment
import com.yagizgokce.travelguideapp.presentation.home.ui.HomeFragment
import com.yagizgokce.travelguideapp.presentation.plan.ui.TripPlanFragment
import com.yagizgokce.travelguideapp.presentation.search.ui.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

private val homeFragment= HomeFragment()
private val searchFragment= SearchFragment()
private val tripPlanFragment= TripPlanFragment()
private val guideFragment= GuideFragment()

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("PATIKA","MAIN")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurrentFragment(homeFragment)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(homeFragment)
                R.id.search->setCurrentFragment(searchFragment)
                R.id.plan->setCurrentFragment(tripPlanFragment)
                R.id.guide->setCurrentFragment(guideFragment)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    }
}