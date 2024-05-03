package com.xcheko51x.crud_room_compose_kotlin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.xcheko51x.crud_room_compose_kotlin.viewmodels.LibrosViewModel
import com.xcheko51x.crud_room_compose_kotlin.views.AgregarView
import com.xcheko51x.crud_room_compose_kotlin.views.EditarView
import com.xcheko51x.crud_room_compose_kotlin.views.InicioView

@Composable
fun NavManager(viewModel: LibrosViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            InicioView(navController, viewModel)
        }

        composable("agregar") {
            AgregarView(navController, viewModel)
        }

        composable("editar/{id}/{libro}/{autor}/{fecha_lanzamiento}/{genero}", arguments = listOf(
            navArgument("id"){type= NavType.IntType},
            navArgument("libro"){type= NavType.StringType},
            navArgument("autor"){type= NavType.StringType},
            navArgument("fecha_lanzamiento"){type= NavType.IntType},
            navArgument("genero"){type= NavType.StringType}
        )){
            EditarView(navController,viewModel,
                it.arguments!!.getInt("id"),
                it.arguments!!.getString("libro"),
                it.arguments!!.getString("autor"),
                it.arguments!!.getInt("fecha_lanzamiento"),
                it.arguments!!.getString("genero"),
            )
        }
    }

}