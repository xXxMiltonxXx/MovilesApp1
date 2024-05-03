package com.xcheko51x.crud_room_compose_kotlin.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xcheko51x.crud_room_compose_kotlin.models.Libros
import com.xcheko51x.crud_room_compose_kotlin.room.LibrosDatabaseDao
import com.xcheko51x.crud_room_compose_kotlin.states.LibrosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LibrosViewModel(
    private val dao: LibrosDatabaseDao
): ViewModel() {

    var state by mutableStateOf(LibrosState())
        private set

    init {
        viewModelScope.launch {
            dao.obtenerLibros().collectLatest {
                state = state.copy(
                    listaLibros = it
                )
            }
        }
    }

    fun agregarLibro(libro: Libros) = viewModelScope.launch {
        dao.agregarLibro(libro = libro)
    }
    fun actualizarLibro (libro:Libros) = viewModelScope.launch {
        dao.actualizarLibro(libro=libro)
    }

    fun borrarLibro (libro:Libros) = viewModelScope.launch {
        dao.borrarLibro(libro=libro)
    }

}