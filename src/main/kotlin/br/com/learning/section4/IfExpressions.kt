package br.com.learning.br.com.learning.section4


fun main() {

    val myInt = 199
    val aInt: Int = 7

   // Int lowest = (myInt < aInt) ? myInt : aInt ; // como seria em Java ternário é um statement e não uma expressão

    val lowest = if(myInt < aInt) myInt else aInt// se o if for utilizado como expressão ele deve ter o else no final

    val temp = 25
    val isAirConditioningOn = if(temp >= 26) { // o ultimo valor mostrado como resultado da expressão é o que deverá ser retornado
        println("Its hot")
        true // será usado como o return da expressão
    }else {
        println("its not hot yet")
        false // será usado como return da expressão
    }

    println("Is the air conditioning on: $isAirConditioningOn")

}