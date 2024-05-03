package com.xcheko51x.crud_room_compose_kotlin.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros")
data class Libros(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "libro")
    val libro: String,
    @ColumnInfo(name = "autor")
    val autor: String,
    @ColumnInfo(name = "fecha_lanzamiento")
    val fecha_lanzamiento: Int,
    @ColumnInfo(name = "genero")
    val genero: String,
)
