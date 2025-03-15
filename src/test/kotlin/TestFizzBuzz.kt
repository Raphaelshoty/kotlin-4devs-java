
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun fizzBuzz(n: Int): List<String> {
    val list = mutableListOf<String>()
    for (num in 1.rangeTo(n)){
        if(num %3 == 0 && num %5 == 0) {
            list.add("FizzBuzz")
        } else if(num %3 == 0){
            list.add("Fizz")
        } else if(num %5 == 0){
            list.add("Buzz")
        } else {
            list.add(num.toString())
        }
    }
    return list
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


