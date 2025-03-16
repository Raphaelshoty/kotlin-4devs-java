
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

// todo - implementar de formas mais elegantes o código do fizzbuzz

//private fun fizzBuzz(n: Int): List<String> {
//    val list = mutableListOf<String>()
//    for (num in 1.rangeTo(n)){
//        if(num %3 == 0 && num %5 == 0) {
//            list.add("FizzBuzz")
//        } else if(num %3 == 0){
//            list.add("Fizz")
//        } else if(num %5 == 0){
//            list.add("Buzz")
//        } else {
//            list.add(num.toString())
//        }
//    }
//    return list
//}

//fun fizzBuzz(n: Int):List<String> {
//    val list = mutableListOf<String>()
//    (1..n).forEach{
//        when {
//            it % 15 == 0 -> list.add("FizzBuzz")
//            it % 3 == 0 -> list.add("Fizz")
//            it % 5 == 0 -> list.add("Buzz")
//            else -> list.add(it.toString())
//        }
//    }
//    return list
//}

//fun fizzBuzz(n: Int): List<String> {
//    val list = mutableListOf<String>()
//    for (it in 1.rangeTo(n)){
//        val result = when {
//            it % 15 == 0 -> "FizzBuzz"
//            it % 3 == 0 -> "Fizz"
//            it % 5 == 0 -> "Buzz"
//            else -> it.toString()
//        }
//        list.add(result)
//    }
//    return list
//}


// solução mais elegante
fun fizzBuzz(n: Int): List<String> {
    return (1..n).map { // (1..n) é mais performático que (it in in rangeTo(n))
        //o map em uma coleção, para cada elemento desta ele realiza uma operação e retorna uma nova coleção ao final
        // das operações
        when{ // when sem passar uma variável é mais conciso e cada resultado das expressões pode ser retornado
            // o que neste caso é retornado um valor que é armazenado na nova coleção que será retornada no final
            it %15 ==0 -> "FizzBuzz"
            it % 3 == 0 -> "Fizz"
            it % 5 == 0 -> "Buzz"
            else -> it.toString()
        }
    }
}


class TestFizzBuzz {

    @Test
    fun `Calling fizzbuzz with "5" returns list with 5 items`() {
        fizzBuzz(5) shouldBeEqualTo listOf("1", "2", "Fizz", "4", "Buzz")
    }

    @Test
    fun `Calling fizzbuzz with 16 returns out the correct values`() {

        val list = listOf(
            "1", "2", "Fizz", "4", "Buzz", "Fizz",
            "7", "8", "Fizz", "Buzz", "11", "Fizz",
            "13", "14", "FizzBuzz", "16"
        )

        fizzBuzz(16) shouldBeEqualTo list
    }
}


