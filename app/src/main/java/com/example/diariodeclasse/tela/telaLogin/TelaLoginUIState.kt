package com.example.diariodeclasse.tela.telaLogin

data class TelaLoginUIState(

    val login:String="",
    val senha:String="",
    val erroLogin:Boolean=false,
    val logado:Boolean=false
)
