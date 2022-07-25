package com.example.bkash

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.app.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.bkash.adapters.ViewPageAdapter
import com.example.bkash.viewModels.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        // Handle the splash screen transition.
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewpager = findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ViewPageAdapter(supportFragmentManager, lifecycle)

        viewpager.adapter = adapter

        TabLayoutMediator(tabLayout, viewpager){tab, position->
            when(position){
                0->{
                    tab.text="Bkash"
                }
                1->{
                    tab.text="Nagad"
                }
            }
        }.attach()




    }
}