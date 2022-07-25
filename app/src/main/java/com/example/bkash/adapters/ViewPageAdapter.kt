package com.example.bkash.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bkash.fragments.BkashFragment
import com.example.bkash.fragments.NagadFragment


class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle:Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0-> {


               BkashFragment()
            }
            1-> {
                NagadFragment()
            }
            else->{
                Fragment()
            }
        }
    }
}