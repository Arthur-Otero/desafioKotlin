package br.com.desafioKotlin

fun verificarListaAluno(listaAluno : List<Aluno>,codigoAluno: Int): Aluno? {
    listaAluno.forEach{
        if (it.codigo == codigoAluno){
            return it
        }
    }
    return null
}