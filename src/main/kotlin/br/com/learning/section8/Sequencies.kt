package br.com.learning.br.com.learning.section8

fun main() {

    val students = getStudents()
    var sequenceStudents = students.drop(1,).take(3).toList()
    println("Sequence students-> $sequenceStudents")

    val numbers = generateSequence(100) { it+1 }
    println("Numbers ${numbers.drop(5).take(20).toList()}")

    val squares = generateSequence(1) { it+1 }.map{it * it}
    val evenSquares = squares.filter { it % 2 == 0 }
    println("Even squares-> ${evenSquares.take(5).toList()}") // para que a sequence funcione corretamente, tenho que informar os elementos que quero "pegar" para trabalhar

    val fibonacci = generateSequence(1 to 1) { it.second to it.first + it.second  }.map { it.first }
    println("Fibonacci -> ${ fibonacci.take(15).toList() }" )
}