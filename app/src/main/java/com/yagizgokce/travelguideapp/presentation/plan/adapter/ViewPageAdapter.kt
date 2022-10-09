package com.yagizgokce.travelguideapp.presentation.plan.adapter

import android.os.Parcelable
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yagizgokce.travelguideapp.presentation.plan.ui.BookmarkFragment
import com.yagizgokce.travelguideapp.presentation.plan.ui.TripFragment

private const val NUM_TABS = 2
class ViewPageAdapter(fa: Fragment) : FragmentStateAdapter(fa) {



    override fun getItemCount(): Int {
        return  NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return TripFragment()
            1 -> return BookmarkFragment()
        }
        return TripFragment()
    }

}
