package com.hide09.praktikum.pertemuan7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.hide09.praktikum.R
import com.hide09.praktikum.databinding.ActivityGameFragmentBinding

class GameFragment : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityGameFragmentBinding>(
            this, R.layout.activity_game_fragment)
        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragmentGame)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragmentGame)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}