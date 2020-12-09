package br.com.desafioKotlin

class Curso(val nome:String, val codigoCurso:Int, val quatidadeAlunos:Int){

    val listaAlunos = mutableListOf<Aluno>()
    var professorTitular: ProfessorTitular? =null
    var professorAdjunto: ProfessorAdjunto? =null

    fun adicionarUmAluno(umAluno: Aluno):Boolean{
        return if (listaAlunos.size == quatidadeAlunos){
            false
        }else{
            listaAlunos.add(umAluno)
            true
        }
    }

    fun excluirAluno(umAluno: Aluno){
        if(listaAlunos.contains(umAluno)){
            listaAlunos.remove(umAluno)
            println("Aluno removido com sucesso")
        }else {
            println("Dados invalidos")
        }
    }

}