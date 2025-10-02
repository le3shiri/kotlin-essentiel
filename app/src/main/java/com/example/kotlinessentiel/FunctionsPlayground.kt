package com.example.kotlinessentiel


//  Fonction 1: greet(name: String, punctuation: String = "!")
fun greet(name: String, punctuation: String = "!") =
    "Bonjour, ${name.trim()}$punctuation"

//  Fonction 2: avg(vararg numbers: Int)
fun avg(vararg numbers: Int): Double = numbers.average()

//  Extension: String.sanitized()
fun String.sanitized(): String =
    this.trim().replace(Regex("\\s+"), " ")

// main(): afficher les résultats attendus
fun main() {
    println("=== Résultats de FunctionsPlayground ===")

    //  Test 1: greet
    println(greet("Ada"))                   // Bonjour, Ada!
    println(greet(" Alan ", "!!"))          // Bonjour, Alan!!

    //  Test 2: avg
    println(avg(1, 2, 3, 4))                // 2.5
    val arr = intArrayOf(10, 20, 30)
    println(avg(*arr))                      // 20.0

    //  Test 3: extension String.sanitized()
    val messy = "   Hello    Kotlin   World   "
    println(messy.sanitized())              // Hello Kotlin World
}
