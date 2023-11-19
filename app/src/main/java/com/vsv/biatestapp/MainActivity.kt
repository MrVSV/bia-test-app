package com.vsv.biatestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.vsv.biatestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController by lazy {
        (supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            .navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavView.setupWithNavController(navController)
        val navViewGoneList = listOf(
            R.id.enterCodeFragment,
            R.id.enterPhoneNumberFragment
        )
        navController.addOnDestinationChangedListener { _, dest, _ ->
            if (dest.id in navViewGoneList) binding.bottomNavView.visibility = View.GONE
            else binding.bottomNavView.visibility = View.VISIBLE
        }

    }
}