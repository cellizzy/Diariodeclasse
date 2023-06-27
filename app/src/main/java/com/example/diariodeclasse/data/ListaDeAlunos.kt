package com.example.diariodeclasse.data

import com.example.diariodeclasse.model.Aluno

class ListaDeAlunos {
    fun carregarListaDeAlunos(): List<Aluno> {
        return listOf<Aluno>(
            Aluno("Gael", "TI"),
            Aluno("Celina ", "Criação de App"),
            Aluno("Gael", "TI"),
            Aluno("Celina", "Criação de App"),
            Aluno("Gael", "TI"),
            Aluno("Celina", "Criação de App"),
            Aluno("Gael", "TI")
        )
    }
}