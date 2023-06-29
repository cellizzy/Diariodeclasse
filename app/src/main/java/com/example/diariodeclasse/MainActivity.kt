package com.example.diariodeclasse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diariodeclasse.tela.TelaListadeAlunos
import com.example.diariodeclasse.tela.Telalogin
import com.example.diariodeclasse.ui.theme.DiarioDeClasseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiarioDeClasseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppDiariodeClasse()

                }
            }
        }
    }
}
    @Composable
fun AppDiariodeClasse(){

val controleDeNavegacao= rememberNavController()
        NavHost(
            navController = controleDeNavegacao,
            startDestination = "telalogin"
        ){
            composable(
                route= "telaDelogin"

            ){
                Telalogin(controleDeNavegacao)
            }
            composable(
               route= "TelaListadeAlunos"
            ){
                TelaListadeAlunos(controleDeNavegacao)

            }

        }
}
