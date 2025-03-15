package br.com.learning.br.com.learning.section4._0101


fun main() {

    var index = 0
    for (item in 10.rangeTo(30).step(2)){
        println("(${++index} ) $item, ")// para o caso de uma expressão dentro da string use ${variável}
    }

    println()

    for ((indx ,item) in 10.rangeTo(10).step(2).withIndex()){ // para trabalhar com index informe .withIndex()
        println("(${indx +1} ) $item, ")// para o caso de uma expressão dentro da string use ${variável}
    }

    println()

    val myArray = arrayOf(10,20,30,40,50)
    for(item in myArray.indices){
        println("at index ${item} is ${myArray[item]}")
    }

}