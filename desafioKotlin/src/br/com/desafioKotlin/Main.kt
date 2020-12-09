package br.com.desafioKotlin

fun main() {
    val digitalHouse = DigitalHouseManager()

    digitalHouse.registrarCurso("Full Stack", 20001,3)
    digitalHouse.registrarCurso("Android", 20002,2)
    digitalHouse.registrarCurso("Curso C",20003,5)

    digitalHouse.excluirCurso(2003)

    digitalHouse.registrarProfessorTitular("Mario", "Vergara", 55, "Ingles")
    digitalHouse.registrarProfessorTitular("Talita", "Flores", 20, "Programação C")

    digitalHouse.excluirCurso(20003)
    digitalHouse.excluirProfessor(22)
    digitalHouse.excluirProfessor(65)

    digitalHouse.registrarProfessorAdjunto("Rita", "Lee", 25, 7)
    digitalHouse.registrarProfessorAdjunto("Maria", "Rosa", 15, 8)
    digitalHouse.registrarProfessorAdjunto("Rosa","Maria",25,10)

    digitalHouse.alocarProfessores(20002,5,0)
    digitalHouse.alocarProfessores(20001,55,15)
    digitalHouse.alocarProfessores(20002,20,15)

    digitalHouse.registrarAluno("Samir", "Leite",22)
    digitalHouse.registrarAluno("Anselmo", "Vaz",33)
    digitalHouse.registrarAluno("Geralt", "Rivia",44)
    digitalHouse.registrarAluno("Enzo", "Morais",44)

    digitalHouse.matricularAluno(22,20001)
    digitalHouse.matricularAluno(33,20001)
    digitalHouse.matricularAluno(44,20002)
    digitalHouse.matricularAluno(55,20002)
    digitalHouse.matricularAluno(66,20002)
}

