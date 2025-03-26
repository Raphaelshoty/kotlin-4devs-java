package br.com.learning.br.com.learning.section4


fun main() {
    println("10 + 20 = ${myMathFunction(10,20)}")
    println("10 + 20 = ${myMathFunctionShort(10,20)}")
    println("10 + 20 = ${myMathFunctionEvenShorter(10,20)}")
    println("10 + 20 = ${myFunctionWithDefaults(10,20)}")
    println("Default sum = ${myFunctionWithDefaults(message =  "Hello !")}")
    println("sum = ${myFunctionWithDefaults(message =  "Hello !", num2 = 3,  num1 = 5)}")

}

fun myMathFunction(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun myMathFunctionShort(num1: Int, num2: Int) : Int = num1 + num2

fun myMathFunctionEvenShorter(num1: Int, num2: Int) = num1 + num2

fun myFunctionWithDefaults(num1: Int = 1, num2: Int = 5, message: String = "Hi") :Int {
    val result = num1+num2
    println(message)
    return result
}