package com.okeanarium.ocean.database_client

import androidx.room.*

@Dao
interface BuyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBuyItem(buyItem: BuyItem)

    @Update
    fun updateBuyItem(buyItem: BuyItem)

    @Query("DELETE FROM BuyItem where suvId = :suvId")
    fun deleteBuyItem(suvId:Int)

    @Query("SELECT * FROM BuyItem")
    fun getBuyItem(): List<BuyItem>

    @Query("SELECT * FROM BuyItem where id = :id")
    fun getBuyItemById(id:Int): BuyItem

    @Query("SELECT * FROM BuyItem where suvId = :suvId")
    fun getBuyItemBySuvId(suvId:Int): BuyItem
}