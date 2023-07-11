package com.example.diariodeclasse.tela

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.diariodeclasse.R
import com.example.diariodeclasse.tela.telaLogin.TelaLoginViewModel

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Telalogin(
    controleDeNavegacao: NavHostController,
telaLoginViewModel: TelaLoginViewModel= viewModel()
) {
    val telaLoginUIState by telaLoginViewModel.telaLoginUIState.collectAsState()


    Card(
        modifier = Modifier
            .padding(20.dp)


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()

        ) {

        }
        Text(
            text = "Login"
        )
        Image(
            painter = painterResource(id = R.drawable.vanellope),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)

        )
        Spacer(modifier = Modifier.size(20.dp))
        TextField(
            value = telaLoginViewModel.login,
            onValueChange = { telaLoginViewModel.updateLogin(it)},
            label = { Text(text = "Login")}
        )
        Spacer(modifier = Modifier.size(20.dp))
        TextField(value = telaLoginViewModel.senha,
            onValueChange = { telaLoginViewModel.updateSenha(it)}
        )
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                telaLoginViewModel.logarUsuario()
                if (telaLoginUIState.logado){
                    controleDeNavegacao.navigate()
                }
            }
        ){
            Text(
                text = "Entrar",
                fontSize = 20.sp,
                color = Color(139, 7, 210),
            )
        }

    }
}
