package com.example.anonymous_store_sprint6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface TelefonoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTelefono(telefonoEntity: List<TelefonoEntity>)

    @Query("Select * from tabla_telefonos order by id ASC")
    fun getTelefonos(): LiveData<List<TelefonoEntity>>

}