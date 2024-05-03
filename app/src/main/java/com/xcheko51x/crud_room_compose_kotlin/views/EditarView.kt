package com.xcheko51x.crud_room_compose_kotlin.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.xcheko51x.crud_room_compose_kotlin.models.Libros
import com.xcheko51x.crud_room_compose_kotlin.viewmodels.LibrosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarView(navController: NavController,viewModel: LibrosViewModel, id:Int, libro:String?, autor:String?, fecha_lanzamiento:Int, genero: String?  ) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar View", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                    }
                }
            )
        }
    ) {
        ContentEditarView(it, navController, viewModel,id, libro, autor, fecha_lanzamiento,genero)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentEditarView(it: PaddingValues,navController: NavController,viewModel: LibrosViewModel,id:Int, libro:String?, autor:String?, fecha_lanzamiento:Int, genero: String? ) {
    var libro by remember {
        mutableStateOf(libro)
    }
    var autor by remember {
        mutableStateOf(autor)
    }
    var fecha_lanzamiento by remember { mutableStateOf(fecha_lanzamiento) }

    var genero by remember {
        mutableStateOf(genero)
    }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = libro?:"" , onValueChange = {libro =it},
            label = { Text(text = "libro")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(value = autor?:"" , onValueChange = {autor =it},
            label = { Text(text = "Autor")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = fecha_lanzamiento.toString(),
            onValueChange = {
                fecha_lanzamiento = it.toIntOrNull() ?: 0
            },
            label = { Text(text = "Fecha de lanzamiento") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start)
        )
        OutlinedTextField(
            value = genero?:"",
            onValueChange = { genero = it },
            label = { Text(text = "Género") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        Button(onClick ={

            val libro = Libros(id=id, libro = libro!!, autor = autor!!, fecha_lanzamiento = fecha_lanzamiento, genero = genero!!)

            viewModel.actualizarLibro(libro)
            navController.popBackStack()
        }
        ) {
            Text(text = "Actualizar")
        }
    }
}