package com.okeanarium.ocean

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.okeanarium.ocean.database_server.AppDatabase
import com.okeanarium.ocean.database_server.InitDatabase
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val db = AppDatabase.getAppDataBase(this)!!

        InitDatabase().InitDatabase(db)
        val bottom_bar = findViewById<AnimatedBottomBar>(R.id.bottom_bar)





        bottom_bar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when (newTab.id) {
                    R.id.first -> {
                        val fragment = SeansFragment(db)
                        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
                            .commit()
                    }
                    R.id.second -> {
                        val fragment = suveniierFragment(db)
                        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
                            .commit()
                    }
                    R.id.third -> {
                        val fragment = AboutUs()
                        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
                            .commit()
                    }
                }

            }
        })
    }


    public fun openBusket(){
        val fragment = BasketFragment();
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}