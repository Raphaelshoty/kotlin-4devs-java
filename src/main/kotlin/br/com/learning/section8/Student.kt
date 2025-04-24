package br.com.learning.br.com.learning.section8

data class Student(val name: String, val age: Int)

fun getStudents(): List<Student> {
    return listOf(
        Student("Renato", 26),
        Student("Hermes", 28),
        Student("Away", 40),
        Student("Boça",18),
        Student("Detonator",30),
    )
}
