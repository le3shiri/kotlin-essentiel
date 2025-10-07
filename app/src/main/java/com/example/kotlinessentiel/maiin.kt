package com.example.kotlinessentiel


data class Todo(val id: Int, val title: String, val done: Boolean)

fun filterAndSortTodos(todos: List<Todo>, query: String): List<Todo> {
    return todos
        .filter { it.title.contains(query, ignoreCase = true) }
        .sortedBy { it.title.lowercase() }
}

fun todosAsSections(todos: List<Todo>): Map<String, List<Todo>> {
    return todos.groupBy { if (it.done) "Terminées" else "À faire" }
}

fun safeMapAccess(m: Map<String, Int>, key: String): Int {
    // Exemple d'accès sûr : si la clé n'existe pas, retourner 0
    return m[key] ?: 0
}

fun bigProcessing(ids: List<Int>): List<Int> {
    return ids.asSequence()
        .filter { it % 2 == 0 }
        .map { it * it }
        .toList()
}

fun main() {
    val todos = listOf(
        Todo(1, "Étudier Kotlin", true),
        Todo(2, "Coder UI", false),
        Todo(3, "Écrire tests", true),
        Todo(4, "Composer app", false)
    )

    println(filterAndSortTodos(todos, "kotlin"))
    println(todosAsSections(todos))

    val m = mapOf("a" to 1, "b" to 2)
    println(safeMapAccess(m, "c")) // doit donner 0

    val large = (1..100000).toList()
    println(bigProcessing(large).take(10))
}
