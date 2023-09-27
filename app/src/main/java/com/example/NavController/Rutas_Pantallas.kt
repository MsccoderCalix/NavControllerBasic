package com.example.NavController

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Rutas_Pantallas {
    val route: String
    val selectedIcon: ImageVector
    val unselectedIcon: ImageVector
}

object Home : Rutas_Pantallas {
    override val route = "home"
    override val selectedIcon = Icons.Filled.Home
    override val unselectedIcon = Icons.Filled.Home
}

object Home1 : Rutas_Pantallas {
    override val route = "home1"
    override val selectedIcon = Icons.Filled.LocationOn
    override val unselectedIcon = Icons.Filled.LocationOn
}

object Home2 : Rutas_Pantallas {
    override val route = "home2"
    override val selectedIcon = Icons.Filled.Home
    override val unselectedIcon = Icons.Filled.Home
}

object Home2_1 : Rutas_Pantallas {
    override val route = "home2_1"
    override val selectedIcon = Icons.Filled.Home
    override val unselectedIcon = Icons.Filled.Home

    const val parametroString: String = "parametroString"
    const val parametroInt: String = "parametroInt"

    val routeWithArgs = "${route}/{${parametroString}}/{${parametroInt}}"

    val arguments = listOf(
        navArgument(parametroString) { type = NavType.StringType; defaultValue = "nodata" } ,
        navArgument(parametroInt) { type = NavType.IntType; defaultValue = -100 }
    )
}
object Home2_2 : Rutas_Pantallas {
    override val route = "home2_2"
    override val selectedIcon = Icons.Filled.Home
    override val unselectedIcon = Icons.Filled.Home

    const val parametroOpcionalString: String = "parametroOpcionalString"
    const val parametroOpcionalInt: String = "parametroOpcionalInt"

    val routeWithArgs = "${route}?${parametroOpcionalString}={${parametroOpcionalString}}&${parametroOpcionalInt}={${parametroOpcionalInt}}"

    val arguments = listOf(
        navArgument(parametroOpcionalString) {defaultValue = "nodata"  },
        navArgument(parametroOpcionalInt) {defaultValue = -100 }
    )
}
/*        navArgument(parametroOpcionalString) { type = NavType.StringType; defaultValue = "nodata"  },
        navArgument(parametroOpcionalInt) { type = NavType.IntType; defaultValue = -100 }
        */

val Rutas_De_Pantallas_lista = listOf(Home, Home1, Home2, Home2_1, Home2_2)