package com.example.anonymous_store_sprint6.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.anonymous_store_sprint6.data.local.TelefonoDao
import com.example.anonymous_store_sprint6.data.local.TelefonoEntity
import com.example.anonymous_store_sprint6.data.remote.CellApi

class Repositorio(private val cellApi: CellApi,private val telefonoDao: TelefonoDao) {

    fun obtenerCelulares(): LiveData<List<TelefonoEntity>> = telefonoDao.getTelefonos()

    suspend fun cargarTelefonos(){
        try {
            val response = cellApi.getDataCell()
            if (response.isSuccessful) {
                val resp = response.body()
                resp?.let { celu ->
                    val telefonoEntity = celu.map {it.transformar() }
                    telefonoDao.insertTelefono(telefonoEntity)
                }
            } else {
                Log.e("repositorio", response.errorBody().toString())
            }
        }catch (exception: Exception){
            Log.e("catch","")
        }
    }


}