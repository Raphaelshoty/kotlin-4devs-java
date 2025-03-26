package br.com.learning.br.com.learning.section5.interfaces

fun main(){

    val newCar = Car()
    newCar.start()
    println("Car automaker is ${newCar.automaker}")
    println("Car Kilometers per liter = ${newCar.getKmPerLiter()}")

}