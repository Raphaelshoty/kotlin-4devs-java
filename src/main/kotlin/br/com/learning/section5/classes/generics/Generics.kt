package br.com.learning.br.com.learning.section5.classes.generics

fun main(){

    val maxInt: Int = max(42,99)
    val maxLong: Long = max(365897L, 75395164825L)
    val maxByte: Byte = max((-128).toByte(), (127).toByte())
    val maxString: String = max("Alpha", "Omega")

    println("The max Int = $maxInt")
    println("The max Long = $maxLong")
    println("The max Byte = $maxByte")
    println("The max String = $maxString")

}