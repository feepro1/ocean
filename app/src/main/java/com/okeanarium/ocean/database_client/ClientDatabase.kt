package com.okeanarium.ocean.database_client

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BuyItem::class], version = 2
)
abstract class ClientDatabase : RoomDatabase() {
    abstract fun BuyDao(): BuyDao

    companion object {
        var INSTANCE: ClientDatabase? = null

        fun getAppDataBase(context: Context): ClientDatabase? {
            if (INSTANCE == null){
                synchronized(ClientDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, ClientDatabase::class.java, "clientDB").allowMainThreadQueries().fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}