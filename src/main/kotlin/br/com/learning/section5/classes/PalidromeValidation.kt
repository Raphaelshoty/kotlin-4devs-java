package br.com.learning.br.com.learning.section5.classes

object PalidromeValidation {
    fun isPalindrome(str: String): Boolean {
        return str.reversed() == str
    }
}