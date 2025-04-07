package br.com.learning.br.com.learning.section7

fun main() {

    val person = Person("Biruleibe", "Diferente")

    val kClass = person::class

    //println("Simple name $kClass")
    println("Simple name ${kClass.simpleName}")

//    for(fields in kClass.members){ // members vai trazer todas propriedades da classe
//        println("Property name = $fields")
//    }

    for (fields in kClass.java.declaredFields) { // java.declaredFields vai trazer todas propriedades que declarei na classe
        //println("Property name = $fields")
        println("Property name = ${fields.name}")
    }

    for (constructor in kClass.constructors) { // java.declaredFields vai trazer todas propriedades que declarei na classe
        println("Constructor = $constructor")
        println("Constructor = ${constructor.returnType}")
        println("Constructor = ${constructor.parameters}")
    }


}