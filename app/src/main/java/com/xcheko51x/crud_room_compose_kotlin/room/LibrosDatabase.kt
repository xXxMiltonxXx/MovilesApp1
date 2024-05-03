package com.xcheko51x.crud_room_compose_kotlin.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xcheko51x.crud_room_compose_kotlin.models.Libros


@Database(
    entities = [Libros::class],
    version = 1,
    exportSchema = false

)
abstract class LibrosDatabase: RoomDatabase() {
    abstract fun librosDao(): LibrosDatabaseDao
}