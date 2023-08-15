package com.example.anonymous_store_sprint6.vistas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.anonymous_store_sprint6.data.Repositorio
import com.example.anonymous_store_sprint6.data.local.TelefonoDataBase
import com.example.anonymous_store_sprint6.data.remote.CellRetroFit
import kotlinx.coroutines.launch

class CellViewModel(application: Application): AndroidViewModel(application) {

    private val repositorio: Repositorio

    fun celularLiveData() = repositorio.obtenerCelulares()

    init {
        val api = CellRetroFit.gedRetroFitCell()
        val telefonoDataBase = TelefonoDataBase.getDatabase(application).getTelefonoDao()
        repositorio = Repositorio(api,telefonoDataBase)
    }

    fun getAllTelefonos() = viewModelScope.launch {
        repositorio.cargarTelefonos()
    }


}