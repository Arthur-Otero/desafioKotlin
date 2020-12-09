package br.com.desafioKotlin

import java.lang.Exception
import java.util.*

class DigitalHouseManager (){

    val listaAluno = mutableListOf<Aluno>()
    val listaCurso = mutableListOf<Curso>()
    val listaMatricula = mutableSetOf<Matricula>()
    val listaProfessor = mutableListOf<Professor>()


    fun registrarCurso(nome: String, codigoCurso: Int,quantidadeMaximaDeAlunos: Int){
        val curso = Curso(nome,codigoCurso,quantidadeMaximaDeAlunos)

        if (verificarListaCurso(listaCurso, codigoCurso) != null){
            println("Codigo de curso invalido")
        }
        else {
            listaCurso.add(curso)
            println("Curso $nome com um limite de $quantidadeMaximaDeAlunos alunos foi criado!")
        }
    }

    fun excluirCurso(codigoCurso: Int){
        val curso = verificarListaCurso(listaCurso, codigoCurso)

        if (curso == null){
            println("Codigo de curso invalido")
        }else{
            println("Curso ${curso.nome} removido")
            listaCurso.remove(curso)
        }
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int){
        val professor = ProfessorAdjunto(quantidadeDeHoras,nome,sobrenome,codigo = codigoProfessor)

        if (verificarListaProfessor(listaProfessor, codigoProfessor) !=null){
            println("Codigo do professor Adjunto registrado")
        }
        else {
            listaProfessor.add(professor)
            println("Professor adjunto $nome $sobrenome com limite de horario de $quantidadeDeHoras horas registrado com sucesso")
        }
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String){
        val professor = ProfessorTitular(especialidade,nome,sobrenome,codigo = codigoProfessor)

        if (verificarListaProfessor(listaProfessor, codigoProfessor) !=null){
            println("Codigo do professor Titular registrado")
        }
        else {
            listaProfessor.add(professor)
            println("Professor titular $nome $sobrenome especialista em $especialidade registrado com sucesso")
        }
    }

    fun excluirProfessor(codigoProfessor: Int){
        val professor = verificarListaProfessor(listaProfessor, codigoProfessor)

        if (professor==null){
            println("Codigo professor invalido")
        }else{
            listaProfessor.remove(professor)
            println("Professor ${professor.nome} ${professor.sobrenome} com seu codigo ${professor.codigo} removido")
        }
    }

    fun registrarAluno(nome:String,sobrenome:String,codigoAluno:Int){
        val aluno = Aluno(nome,sobrenome,codigoAluno)

        if (verificarListaAluno(listaAluno, codigoAluno) !=null){
            println("Codigo ja registrado")
        }
        else {
            listaAluno.add(aluno)
            println("Aluno $nome $sobrenome resgitrado com sucesso")
        }
    }

    fun matricularAluno(codigoAluno: Int,codigoCurso: Int){
        val data = Date(2020,12,5)
        val curso = verificarListaCurso(listaCurso, codigoCurso)
        val aluno = verificarListaAluno(listaAluno, codigoAluno)

        if (curso == null || aluno == null){
            println("Codigo invalido")
        }else {
            if(curso.adicionarUmAluno(aluno)){
                val matricula = Matricula(aluno,curso,data)
                listaMatricula.add(matricula)
                println("Matricula do aluno ${aluno.nome} ${aluno.sobrenome} no curso ${curso.nome} realizada com sucesso")
            }
        }
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        var titular : ProfessorTitular? =null
        var adjunto : ProfessorAdjunto? =null

        try{
            titular = verificarListaProfessor(listaProfessor,codigoProfessorTitular) as ProfessorTitular?
            adjunto = verificarListaProfessor(listaProfessor,codigoProfessorAdjunto) as ProfessorAdjunto?
        }catch (ex : Exception){
            adjunto = null
            titular = null
        }

        if (adjunto == null || titular == null)   println("Codigo de professor invalido")
        else{
            listaCurso.forEach{
                if (it.codigoCurso == codigoCurso){
                    it.professorTitular = titular
                    it.professorAdjunto = adjunto
                    println("Professor titular ${titular.nome} ${titular.sobrenome} e professor adjunto ${adjunto.nome} ${adjunto.sobrenome} alocados para o curso ${it.nome}")
                }
            }
        }
    }
}