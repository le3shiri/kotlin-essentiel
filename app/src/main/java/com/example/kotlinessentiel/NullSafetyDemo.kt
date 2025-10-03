package com.example.kotlinessentiel

fun greet(input: String?): String =
    input
        ?.trim()
        ?.takeIf { it.isNotEmpty() }
        ?.let { "Bonjour, $it !" }
        ?: ""


fun parseCount(input: String?): Int =
    input
        ?.trim()
        ?.toIntOrNull()
        ?.coerceAtLeast(0)
        ?: 0


fun safeAt(xs: List<Int>, index: Int): Int =
    xs.getOrNull(index) ?: -1


fun parseAnyToNonNegativeInt(x: Any?): Int =
    when (x) {
        is Int -> x.coerceAtLeast(0)
        is String -> x.toIntOrNull()?.coerceAtLeast(0) ?: 0
        else -> 0
    }


fun lengthOrZero(s: String?): Int =
    s?.length ?: 0


fun nonNullOrFail(s: String?): String =
    requireNotNull(s) { "La valeur ne doit pas etre null !" }


fun main() {
    println("=====  Demonstration de Null Safety =====")

    // 1. greet
    println("\n greet() tests:")
    println(greet(" Aymane ")) // Bonjour, Aymane !
    println(greet("   "))      // ️ ""
    println(greet(null))       // ️ ""

    // 2. parseCount
    println("\n parseCount() tests:")
    println(parseCount(" 42 "))     //  42
    println(parseCount(" -5 "))     //  0 (pas négatif)
    println(parseCount("hello"))    //  0
    println(parseCount(null))       //  0

    // 3. safeAt
    println("\n safeAt() tests:")
    val list = listOf(10, 20, 30)
    println(safeAt(list, 1)) //  20
    println(safeAt(list, 5)) //  -1 (hors limites)

    // 4. parseAnyToNonNegativeInt
    println("\n parseAnyToNonNegativeInt() tests:")
    println(parseAnyToNonNegativeInt(25))         //  25
    println(parseAnyToNonNegativeInt(-7))         //  0
    println(parseAnyToNonNegativeInt("33"))       //  33
    println(parseAnyToNonNegativeInt("text"))     //  0
    println(parseAnyToNonNegativeInt(null))       //  0

    // 5. lengthOrZero
    println("\n🔹 lengthOrZero() tests:")
    println(lengthOrZero("Kotlin")) //  6
    println(lengthOrZero(null))     //  0

    // 6. nonNullOrFail
    println("\n nonNullOrFail() tests:")
    println(nonNullOrFail("Secured Value")) //  Secured Value

    try {
        println(nonNullOrFail(null)) //  va throw IllegalArgumentException
    } catch (e: IllegalArgumentException) {
        println(" Exception attrapee: ${e.message}")
    }
}
