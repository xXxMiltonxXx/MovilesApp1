package com.xcheko51x.crud_room_compose_kotlin.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.xcheko51x.crud_room_compose_kotlin.models.Libros
import kotlinx.coroutines.flow.Flow

@Dao
interface LibrosDatabaseDao {

    @Query("SELECT * FROM libros")
    fun obtenerLibros(): Flow<List<Libros>>

    @Query("SELECT * FROM libros WHERE id= :id")
    fun obtenerLibro(id:Int): Flow<Libros>

    @Insert
    suspend fun agregarLibro (libro:Libros)

    @Update
    suspend fun actualizarLibro (libro:Libros)
    @Delete
    suspend fun borrarLibro (libro:Libros)

}
