package com.okeanarium.ocean.database_server

import androidx.room.*

@Dao
interface SuvenierDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSuvenier(suvenier: Suvenier)

    @Update
    fun updateSuvenier(suvenier: Suvenier)

    @Delete
    fun deleteSuvenier(suvenier: Suvenier)

    @Query("SELECT * FROM Suvenier")
    fun getSuvenier(): List<Suvenier>

    @Query("SELECT * FROM Suvenier where id = :id")
    fun getSuvenierById(id:Int): Suvenier
}