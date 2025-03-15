package br.com.learning.br.com.learning.section4._0101


fun main() {

    val burgerOrdered: Int = 2
    when(burgerOrdered){
        0 -> println("Not Hungry")
        1 -> println("Hungry")
        2 -> println("Very Hungry")
        3 -> println("Starving")
        else -> println("Are you alive ?")
    }
    when(burgerOrdered){
        0 -> println("Not Hungry")
        1,2-> println("Hungry") // neste caso eu posso combinar condições e obter a mesma resposta
        3 -> println("Very Hungry")
        else -> println("Are you alive ?")
    }

    when(burgerOrdered){ // posso combinar expressões neste caso abaixo
        Math.abs(burgerOrdered) -> println("ordered 0 or more burgers")
        else -> println("Ordered less than 0 burgers which is impossible")
    }

    when(burgerOrdered){
        0 -> println("Not Hungry")
        in 1..3-> println("Hungry") // neste caso eu posso combinar condições e obter a mesma resposta
        in 4..5 -> println("Very Hungry")
        else -> println("Are you alive ?")
    }

    when {
        burgerOrdered <= 0 -> println("None ordered")
        burgerOrdered %2 == 1 -> println("odd number of burgers ordered")
        burgerOrdered %2 == 0 -> println("Even number of burgers ordered")
    }

}