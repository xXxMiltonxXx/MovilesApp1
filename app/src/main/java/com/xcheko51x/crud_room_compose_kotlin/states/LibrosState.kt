package com.xcheko51x.crud_room_compose_kotlin.states

import com.xcheko51x.crud_room_compose_kotlin.models.Libros

data class LibrosState(
    val listaLibros: List<Libros> = emptyList()
)

