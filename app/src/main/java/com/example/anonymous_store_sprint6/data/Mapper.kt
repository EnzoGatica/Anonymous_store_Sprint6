package com.example.anonymous_store_sprint6.data

import com.example.anonymous_store_sprint6.data.local.TelefonoDetalleEntity
import com.example.anonymous_store_sprint6.data.local.TelefonoEntity
import com.example.anonymous_store_sprint6.data.remote.Cell
import com.example.anonymous_store_sprint6.data.remote.CellDetalle

fun Cell.transformar(): TelefonoEntity = TelefonoEntity(this.id,this.name,this.price,this.image)

fun CellDetalle.toDetalleEntity(): TelefonoDetalleEntity = TelefonoDetalleEntity(this.id,this.name,this.price,this.image,this.description,this.lastPrice,this.credit)