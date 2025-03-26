package br.com.learning.br.com.learning.section5.classes

fun main(){

    // objec em kotlin define que uma variável simples possa ter propriedades e métodos como em Javascript
    // desta forma um object pode existir sem a necessidade de ser uma instância de uma classe e isso torna o código mais versátil
    val location = object {
        var xCoorinate = 200
        var yCoordinate = 400
    }

    println( "Coordinates = ( ${location.xCoorinate}, ${location.yCoordinate} )" )

    val location2 = object {
        var xCoorinate = 300
        var yCoordinate = 600
        // como observado abaixo, sim uma váriavel no caso location2 pode conter métodos ou funções
        fun printIt() {
            println("Coordinates = ( ${xCoorinate}, ${yCoordinate} )")
        }
    }
    // mesmo que a variável location2 seja imutável,suas propriedades uma vez definidas com var podem ser reescritas
    location2.printIt()
    location2.xCoorinate = 700
    location2.yCoordinate = 14000
    location2.printIt()

    val temperature:Int = MySingleton.lastTemperature()
    println(" the last temperature registered was -> $temperature ")
}

// abaixo podemos definir um object como se fosse uma classe e teremos os mesmos comportamentos definidos anteriormente
object MySingleton {
    var temperatures = arrayOf(18,25,32)
    fun lastTemperature() = temperatures.last()
}