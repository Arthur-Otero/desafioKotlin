package br.com.desafioKotlin

fun verificarListaProfessor(listaProfessor : List<Professor>,codigoProfessor: Int): Professor? {
    listaProfessor.forEach{
        if (it.codigo == codigoProfessor)  return it
    }
    return null
}