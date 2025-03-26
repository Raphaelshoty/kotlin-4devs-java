package br.com.learning.br.com.learning.section4


fun main() {

    var x: Int = 0
    while (x < 10) {
        println("x = $x")
        x += 3
    }

    do{
        println("x = $x")
        x -= 3
    }while (x > 0)

    for(item in 0..10) {
        println("$item, ")
    }

    for(ch in "Raphael Rodrigues Lima") {
        println("$ch, ")
    }

}