package com.example.studycafe.src.main

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.studycafe.R
import com.example.studycafe.config.BaseActivity
import com.example.studycafe.databinding.ActivityMainBinding
import com.example.studycafe.src.main.home.HomeFragment
import com.example.studycafe.src.main.info.InfoFragment
import com.example.studycafe.src.main.setting.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.window?.apply {
            this.statusBarColor = Color.WHITE
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
                BottomNavigationView.OnNavigationItemSelectedListener { item ->
                    when (item.itemId) {
                        R.id.menu_main_btm_nav_home -> {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.main_frm, HomeFragment())
                                    .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                        R.id.menu_main_btm_nav_user -> {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.main_frm, InfoFragment())
                                    .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                        R.id.menu_main_btm_nav_setting -> {
                            supportFragmentManager.beginTransaction()
                                    .replace(R.id.main_frm, SettingFragment())
                                    .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                    false
                })
    }
}