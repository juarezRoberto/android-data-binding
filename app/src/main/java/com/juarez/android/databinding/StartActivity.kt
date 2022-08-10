package com.juarez.android.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.juarez.android.databinding.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start)

        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.navHostFragment.id) as NavHostFragment
        setupActionBarWithNavController(navHostFragment.navController)

        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destionation, _ ->
            when (destionation.id) {
                R.id.firstFragment -> {
//                    window?.navigationBarColor = ContextCompat.getColor(this, R.color.teal_200)
//                    window?.statusBarColor = ContextCompat.getColor(this, R.color.teal_200)
                }
                else -> Unit
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(binding.navHostFragment.id)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}