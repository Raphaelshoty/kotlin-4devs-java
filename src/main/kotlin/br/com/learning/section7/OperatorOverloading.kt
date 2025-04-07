package br.com.learning.br.com.learning.section7

fun main() {

    val coordinates1 = Coordinates(200,100)
    val coordinates2 = Coordinates(300,200)

    val coordinates3 = coordinates1 + coordinates2 // aqui usamos a sobrecarga de operador definido em Coordinates.kt
    // em Coordinates.kt definimos que podemos somar coordenadas e obviamente esta operação não existe naturalmente para o objeto

    println("Coordinates sum is $coordinates3")

}