package com.okeanarium.ocean

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.okeanarium.ocean.database_client.ClientDatabase
import com.okeanarium.ocean.database_server.AppDatabase
import com.okeanarium.ocean.database_server.InitDatabase
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {
    lateinit var servDB :AppDatabase
    lateinit var clientDB :ClientDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        servDB = AppDatabase.getAppDataBase(this)!!
        clientDB = ClientDatabase.getAppDataBase(this)!!
        InitDatabase().InitDatabase(servDB)
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
                        val fragment = SeansFragment(servDB, supportFragmentManager)
                        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
                            .commit()
                    }
                    R.id.second -> {
                        openSuvenier()
                    }
                    R.id.third -> {
                        val fragment = AboutUs()
                        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
                            .commit()
                    }
                }


            }
        })
        Thread.sleep(1000)
        bottom_bar.selectTabById( R.id.third,true)

    }


    public fun openBusket(){
        val fragment = BasketFragment(clientDB,servDB,supportFragmentManager);
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    fun openSuvenier() {
        val fragment = suveniierFragment(servDB,supportFragmentManager)
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
                .commit()
    }

    fun openSeans() {
        val fragment = SeansFragment(servDB,supportFragmentManager)
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}