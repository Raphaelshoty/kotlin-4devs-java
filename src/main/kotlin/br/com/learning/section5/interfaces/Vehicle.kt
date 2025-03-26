package br.com.learning.br.com.learning.section5.interfaces

interface Vehicle {

    val automaker: String

    fun start(){
        println("Vrum")
    }

    fun stop(){
        println("Brake noise")
    }

    fun getKmPerLiter(): Int{
        return 17
    }

    fun getDoors(): Int
}