package com.example.kotlinessentiel

fun main() {
    val name = "Aymane"
    var age = 20
    age = 21

    println(" Salut, je m'appelle $name et j'ai $age ans.")

    val level = 15
    println("Niveau: ${levelLabel(level)}")

    val n = 5
    println("La somme de 0 à $n est ${sum0to(n)}")
}

/**
 * 🎯 Fonction 1: levelLabel(Int): String
 * Détermine le niveau en fonction d'un entier donne
 */
fun levelLabel(count: Int): String = when {
    count < 0 -> "Invalide"
    count == 0 -> "Debutant"
    count in 1..9 -> "Bas niveau"
    count in 10..99 -> "Niveau moyen"
    else -> "Niveau eleve"
}

/**
 * 🎯 Fonction 2: sum0to(Int): Int
 * Calcule la somme de tous les entiers de 0 à n (inclus)
 */
fun sum0to(n: Int): Int {
    require(n >= 0)
    var s = 0
    for (i in 0..n) {
        s += i
    }
    return s
}
