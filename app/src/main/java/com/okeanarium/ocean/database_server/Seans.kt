package com.okeanarium.ocean.database_server

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Seans(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val date: String,
    val times: String,
    val imageURL : String)