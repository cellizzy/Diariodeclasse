package com.example.diariodeclasse.data

import com.example.diariodeclasse.model.Aluno

class ListaDeAlunos {
    fun carregarListaDeAlunos(): List<Aluno> {
        return listOf<Aluno>(
            Aluno("Maria aghata", " Criação de App "),
            Aluno("Celina ", "Criação de App"),
            Aluno("Laura", "Criação de App"),
            Aluno("Pedro", "Criação de App"),
            Aluno("Michele", "Criação de App"),
            Aluno("Rafael", "Criação de App"),
            Aluno("Gael", "Criação de App")
        )
    }
}