package br.com.learning.br.com.learning.section6

class Person internal constructor(var firstName: String, var lastName: String) {// classes marcada como internal pode haver sobrecarga de construtor como mostrado abaixo
    init{
        println("Created a person named $firstName $lastName")
    }
    constructor(firstName: String, lastName: String, middleName: String) :this(firstName, lastName)

}