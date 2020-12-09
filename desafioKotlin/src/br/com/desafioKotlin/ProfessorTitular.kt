package br.com.desafioKotlin

data class ProfessorTitular(
    val especialidade:String,
    override val nome: String,
    override val sobrenome: String,
    override val tempoCasa: Int = 0,
    override val codigo: Int
):Professor()