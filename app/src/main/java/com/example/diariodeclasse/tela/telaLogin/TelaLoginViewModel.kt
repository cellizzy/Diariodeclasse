package com.example.diariodeclasse.tela.telaLogin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TelaLoginViewModel : ViewModel() {

    private val _telaLoginUIState = MutableStateFlow(TelaLoginUIState())
    val telaLoginUIState: StateFlow<TelaLoginUIState> = _telaLoginUIState.asStateFlow()

    var login by mutableStateOf("")

    var senha by mutableStateOf("")

    fun updateLogin(login: String) {
        this.login = login
    }

    fun updateSenha(senha: String) {
        this.senha = senha


    }

    fun updateTelaLoginState(
        erroLogin: Boolean = false,
        logado: Boolean = false
    ) {
        _telaLoginUIState.update { currentState ->
            currentState.copy(
                erroLogin = erroLogin,
                logado = logado
            )
        }
    }

    fun logarUsuario() {
        if (login.isEmpty() || senha.isEmpty()) {
            updateTelaLoginState(erroLogin = true)
            return
        }
    }

}