package br.com.desafioKotlin

fun verificarListaCurso(listaCurso : List<Curso>,codigoCurso: Int): Curso? {
    listaCurso.forEach{
        if (it.codigoCurso == codigoCurso){
            return it
        }
    }
    return null
}