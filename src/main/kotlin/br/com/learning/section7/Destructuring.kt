package br.com.learning.br.com.learning.section7

import br.com.learning.br.com.learning.section5.classes.MySingleton

fun main(){

    val coordinates1 = Coordinates(200,100)
    val coordinates2 = Coordinates(300,200)
    val coordinates3 = coordinates1 + coordinates2
    println(coordinates3)

    val (xCoordinate, yCoordinate) = coordinates3
    println("xCoordinate = $xCoordinate yCoordinate = $yCoordinate" )
    println("xCoordinate = ${coordinates3.component1()}" )

    showComponents()

}

fun showComponents(){
    val myPoint = Point(5000,500,60000)
    val (myX, myY, myZ) = myPoint
    println("myX = $myX, myY = $myY, myZ = $myZ")

}