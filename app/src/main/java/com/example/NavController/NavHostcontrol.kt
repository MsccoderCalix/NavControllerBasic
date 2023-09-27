package com.example.NavController

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        composable(Home.route) {
            //Home(navController= navController)
            Home(navController= navController) {
                navController.navigate("home1") {
                    popUpTo("home") {
                        //inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        }

        composable(Home1.route) {
            Home1(navController)
        }
        composable(Home2.route) {
            Home2(navController)
        }
        composable(
            route= Home2_1.routeWithArgs,
            arguments = Home2_1.arguments
        ) {backStackEntry ->
            Home2_1(navController, backStackEntry.arguments?.getString(Home2_1.parametroString), backStackEntry.arguments?.getInt(Home2_1.parametroInt))
        }

        composable(
            Home2_2.routeWithArgs,
            arguments = Home2_2.arguments
        ) { backStackEntry ->
            Home2_2(navController, backStackEntry.arguments?.getString(Home2_2.parametroOpcionalString), backStackEntry.arguments?.getInt(Home2_2.parametroOpcionalInt))
        }

    }
}

@Composable
@Preview(showBackground = true)
fun MyAppNavHostPreview() {
    MyAppNavHost()
}