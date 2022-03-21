package com.jgeron.dynamicrecyclerviewmenu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jgeron.dynamicrecyclerviewmenu.R
import com.jgeron.dynamicrecyclerviewmenu.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
    }

    private fun initNavigation(){
        val navHostFragment =
            supportFragmentManager
                .findFragmentById(R.id.activity_main_fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        setupActionBarWithNavController(navController,
            AppBarConfiguration(setOf(R.id.none, R.id.radio, R.id.check))
        )
        binding.activityMainBottomNavMenu.setupWithNavController(navController)
    }

}