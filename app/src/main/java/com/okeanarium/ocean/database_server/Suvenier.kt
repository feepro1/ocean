package com.okeanarium.ocean.database_server

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Suvenier(
        @PrimaryKey(autoGenerate = true)
        val id: Int? = null,
        val name: String,
        val description: String,
        val imageURL : String,
        val price:Int = (700..1500).random())