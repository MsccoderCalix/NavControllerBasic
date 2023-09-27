package com.example.NavController

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun Home(
    navController: NavHostController,
    clickTohome1 : ()-> Unit,
) {
    Column(
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla Principal : home")
        Button(
            onClick = clickTohome1
        ) {
            Text(text = "Home1")
        }
        Button(
            onClick = {
                navController.navigate("home2") {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                }
            }
        ) {
            Text(text = "Home2")
        }
    }
}


@Composable
fun Home1(navController: NavHostController) {
    Column(
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla: home1")
        Button(
            onClick = {
                navController.navigateUp()
            }
        ) {
            Text(text = "Regresar a Home")
        }
    }
}

@Composable
fun Home2(
    navController: NavHostController
) {

    Column(
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        var parametroString by remember { mutableStateOf("") }
//        var parametroInt by remember { mutableStateOf("") }

        var parametroString by rememberSaveable { mutableStateOf("") }
        var parametroInt by rememberSaveable { mutableStateOf("") }

        Text(text = "Pantalla: home2")
        TextField(value = parametroString, onValueChange =  {parametroString = it },
            label = { Text(text = "Parametro String") },
            placeholder = { Text(text = "string: ") },
        )
        TextField(value = parametroInt, onValueChange = {parametroInt =  it },
            label = { Text(text = "Parametro int") },
            placeholder = { Text(text = "int: ") },
        )
        Button(
            onClick = {
                navController.navigateUp()
            }
        ) {
            Text(text = "Regresar a Home")
        }
        Button(
            onClick = {
                val ps: String = if(parametroString == "") "nada" else parametroString
                val pi: Int = if(parametroInt == "") -1 else parametroInt.toInt()

                navController.navigate("home2_1/$ps/$pi") {
                    popUpTo(Home2.route) {
                        inclusive = true //Si el destino de popUpTo debe extraerse de la pila de actividades
                        //saveState = true
                    }
                }
            }
        ) {
            Text(text = "Mostrar Home2_1")
        }
        Button(
            onClick = {
                //PARAMETROS OOPCIONALES
                val ps: String = if(parametroString == "") "nada" else parametroString
                val pi: Int = if(parametroInt == "") -1 else parametroInt.toInt()

                navController.navigate("home2_2?parametroOpcionalString=$ps&parametroOpcionalInt=$pi") {
                    popUpTo(Home2.route) {
                     inclusive = false
                    //saveState = true
                    }
                }
            }
        ) {
            Text(text = "Mostrar Home2_2")
        }
    }
}

@Composable
fun Home2_1(
    navController: NavHostController,
    string: String? ,
    int: Int?
) {
    Column(
        //modifier= Modifier.background(color = Color.Gray),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla: home2_1")
        Text(text = "ParametroObligatorioString = $string")
        Text(text = "ParametroObligatorioalInt = $int")

        Button(
            onClick = {
                navController.navigateUp()
                //navController.popBackStack()
            }
        ) {
            Text(text = "Regresar a Home")
        }
    }
}

@Composable
fun Home2_2(
    navController: NavHostController,
    string: String? = "VacioDeFuncion",
    int: Int? = 0
) {
    Column(
        modifier= Modifier.background(color = Color.Blue),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla: home2_2")
        Text(text = "ParametroOpcionalString = ${string}")
        Text(text = "ParametroOpcionalInt = ${int}")
        //Text(text = "home2_2 ParametroString ")
        Button(
            onClick = {
                //navController.popBackStack()
                navController.navigateUp()
            }
        ) {
            Text(text = "Regresar a Home2")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomePreview() {
    Home(rememberNavController(),{})
}
@Composable
@Preview(showBackground = true)
fun Home2_2_Preview() {
    Home2_2(rememberNavController())
}
