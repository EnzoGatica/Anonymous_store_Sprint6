package com.example.anonymous_store_sprint6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_telefonos")
data class TelefonoEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val price: Int,
    val image: String
)