package com.example.anonymous_store_sprint6.data

import com.example.anonymous_store_sprint6.data.local.TelefonoEntity
import com.example.anonymous_store_sprint6.data.remote.Cell

fun Cell.transformar(): TelefonoEntity = TelefonoEntity(this.id,this.name,this.price,this.image)
