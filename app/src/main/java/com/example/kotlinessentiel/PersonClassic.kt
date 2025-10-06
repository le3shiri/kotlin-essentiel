package com.example.kotlinessentiel

// PersonClassic.kt
// Classe normale (classique) — pas de génération automatique

class PersonClassic(val name: String, val age: Int) {

    // Version améliorée : toString lisible
    override fun toString(): String = "PersonClassic(name=$name, age=$age)"

    // Égalité structurelle (equals basé sur contenu)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PersonClassic) return false
        return name == other.name && age == other.age
    }

    // Cohérent avec equals
    override fun hashCode(): Int = 31 * name.hashCode() + age

    // Copie manuelle (imitant data class)
    fun copy(name: String = this.name, age: Int = this.age) = PersonClassic(name, age)
}
