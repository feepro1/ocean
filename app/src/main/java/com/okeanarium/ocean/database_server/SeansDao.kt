package com.okeanarium.ocean.database_server

import androidx.room.*

@Dao
interface SeansDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeans(seans: Seans)

    @Update
    fun updateSeans(seans: Seans)

    @Delete
    fun deleteSeans(seans: Seans)

    @Query("SELECT * FROM Seans")
    fun getSeans(): List<Seans>
}