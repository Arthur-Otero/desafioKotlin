package br.com.desafioKotlin

data class ProfessorAdjunto(
    val horasMentoria:Int,
    override val nome: String,
    override val sobrenome: String,
    override val tempoCasa: Int = 0,
    override val codigo: Int
):Professor()