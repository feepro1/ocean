package com.okeanarium.ocean.database_client

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BuyItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val suvId : Int)