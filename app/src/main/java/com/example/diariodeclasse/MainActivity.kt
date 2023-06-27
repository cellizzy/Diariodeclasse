package com.example.diariodeclasse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diariodeclasse.data.ListaDeAlunos
import com.example.diariodeclasse.model.Aluno
import com.example.diariodeclasse.ui.theme.DiarioDeClasseTheme
import java.nio.file.WatchEvent

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
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn{
            items( ListaDeAlunos().carregarListaDeAlunos()){
                aluno -> Turmakotlin(aluno= aluno)
            }
        }

    }

}

@Composable
fun Turmakotlin(
    aluno: Aluno
) {
    var expandir by remember { mutableStateOf(true) }

    Card(
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessHigh
                    )
                )
        ) {
            Row(
                modifier =
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    painter = painterResource(id = aluno.foto),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(150.dp),
                    contentScale = ContentScale.Crop
                )
                Column() {
                    Text(
                        text = aluno.nome
                    )
                    Text(
                        text = aluno.curso
                    )
                }
                Icon(
                    imageVector =
                    if (expandir)
                        Icons.Filled.KeyboardArrowUp
                    else
                        Icons.Filled.KeyboardArrowDown,

                    contentDescription = null,
                    modifier = Modifier
                        .clickable { expandir = !expandir }
                )
            }
            if (expandir == true) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Faltas: ${aluno.faltas}")
                Text(text = "Nota: ${aluno.nota}")
            }
        }
    }
}

@Preview
@Composable
fun PreviewCardAluno() {
    Turmakotlin(
        aluno = Aluno(
            nome = "Celina Azevedo",
            curso = "criação de Aplicativos"
        )
    )
}