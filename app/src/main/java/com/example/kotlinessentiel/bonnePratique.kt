package com.example.kotlinessentiel

// BonnesPratiquesDemo.kt
// l hdaf: napplyiw f had l fichier chi mmarissat mzyanin f Kotlin
// - smiyat wadi7in
// - kol fonction katdir wa7d l wa9t haja wa7da
// - nst3mlo val bzaf bach nhafdo 3la l immutabilite
// - l code ykoun mqri w sahal lfahm

// data class katmattel wa7d l personne
data class Person(val name: String, val age: Int) {
    // fonction katsawal wach had l personne rashid ola la
    fun isAdult(): Boolean = age >= 18
}

// data class katmattel compteur li ma kaytbdalch
data class Counter(val value: Int = 0) {
    // katrj3 version jdida mn compteur mzida f value 1
    fun increment(): Counter = copy(value = value + 1)

    // katrj3 version jdida zero
    fun reset(): Counter = copy(value = 0)
}

// fonction katrahb b wa7d l personne
fun greet(person: Person): String =
    "Bonjour ${person.name}!"

// fonction katrj3 message 3la 7asab 3mr dyal l personne
fun ageMessage(person: Person): String =
    if (person.isAdult()) "${person.name} est majeur(e)." else "${person.name} est mineur(e)."

// fonction katbayan kifach kaytbdal compteur m3a lwa9t
fun showCounterEvolution(): List<Counter> {
    var counter = Counter() // kanbda bih men 0
    val history = mutableListOf<Counter>() // bach nkonserviw les changements
    repeat(3) {
        counter = counter.increment() // kol marra kanzido 1
        history.add(counter) // n3mrha f liste
    }
    return history // nrj3 liste kamla
}

// fonction principale main
fun main() {
    val sara = Person("Sara", 20)
    val yassine = Person("Yassine", 16)

    println(greet(sara))
    println(ageMessage(sara))

    println(greet(yassine))
    println(ageMessage(yassine))

    println("Historique dyal compteur:")
    val counters = showCounterEvolution()
    counters.forEach { println("Valeur actuelle: ${it.value}") }

    val resetCounter = counters.last().reset()
    println("Reset: ${resetCounter.value}")
}
