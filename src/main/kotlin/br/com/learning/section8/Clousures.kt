package br.com.learning.br.com.learning.section8

fun clousureMaker() : () -> Unit {
    var num = 0
    return { println(num++) }
}

fun main(){
    val myCounter1 = clousureMaker()
    val myCounter2 = clousureMaker()

    myCounter1()
    myCounter1()
    myCounter1()
    myCounter1()
    myCounter2()
    myCounter2()
    myCounter1()
}