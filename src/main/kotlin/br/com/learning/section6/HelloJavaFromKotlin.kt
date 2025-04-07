package br.com.learning.br.com.learning.section6

import section6.Animal

fun main() {

    val cat = Animal("Cookie", "Cat", 8)
    println(cat.show())

    val dog = Animal("Rudock", "Dog", 70)
    println(dog.show())

    cat.weight = 7
    println(cat.show())

    //cat.kind = "bird" // como a propriedade kind em Java está como final, ela é vista no Kotlin como val e não pode sofrer reasign

}