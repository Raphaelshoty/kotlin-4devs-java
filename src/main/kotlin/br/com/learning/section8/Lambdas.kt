package br.com.learning.br.com.learning.section8

fun main(){

    val students = getStudents()
    val combos = students.map{s -> "student name: ${s.name} age: ${s.age}"}
    println("Combos-> $combos")

    println("The oldest student is ${students.maxByOrNull { it.age }}") // caso a expressão tenha apenas um parâmetro como neste caso, posso omitir o arrow -> e apenas
    // referenciar usando o it(o elemento em sí). propriedade desejada
    println("The youngest student is ${students.minByOrNull { it.age }}")

    println("the longest name is ${students.filter { it.name.length > 7 }}")

}