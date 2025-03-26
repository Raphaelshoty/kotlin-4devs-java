package br.com.learning.br.com.learning.section5.classes

//class Person constructor(firstName: String, lastName: String){ }// constructor pode ser omitido
// a palavra constructor deve ser utilizada geralmente para uma classe que tenha um modificador de acesso private, protected e por  aí vai

//class Person (firstName: String, lastName: String) {
//
//    // quando desejo que a classe ou objeto tenha um comportamento padrão ao ser inicializado devemos indicar com um
//    // método chamado init como abaixo
//    init{
//        println("Created a person named $firstName $lastName")
//    }
//
//}

class Person internal constructor(firstName: String, lastName: String) {// classes marcada como internal pode haver sobrecarga de construtor como mostrado abaixo
    init{
        println("Created a person named $firstName $lastName")
    }
    constructor(firstName: String, lastName: String, middleName: String) :this(firstName, lastName)

}