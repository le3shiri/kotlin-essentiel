package com.example.kotlinessentiel

// Main.kt
import kotlin.collections.setOf

fun main() {
    println("=== Étape 1 : Classe normale (par défaut) ===")
    val c1 = PersonClassic("Ada", 36)
    val c2 = PersonClassic("Ada", 36)

    println("c1 == c2 ? ${c1 == c2}") // true (equals redéfini)
    println("toString(): $c1")

    println("\n=== Étape 2 : Data class ===")
    val d1 = PersonData("Ada", 36)
    val d2 = PersonData("Ada", 36)

    println("d1 == d2 ? ${d1 == d2}") // true (égalité structurelle)
    println("toString(): $d1")

    println("\n=== Étape 3 : copy() et déstructuration ===")
    val d3 = d1.copy(age = 37)
    println("Original: $d1")
    println("Copie modifiée: $d3")

    val (name, age) = d3
    println("Déstructuration → name=$name, age=$age")

    println("\n=== Étape 4 : Copy manuelle sur classe normale ===")
    val c3 = c1.copy(age = 40)
    println("Copie manuelle: $c3")

    println("\n=== Étape 5 : Effet dans les collections ===")
    val classicSet = setOf(
        PersonClassic("Ada", 36),
        PersonClassic("Ada", 36)
    )
    println("Taille Set (classique): ${classicSet.size}") // 1 (equals redéfini)

    val dataSet = setOf(
        PersonData("Ada", 36),
        PersonData("Ada", 36)
    )
    println("Taille Set (data class): ${dataSet.size}") // 1
}
