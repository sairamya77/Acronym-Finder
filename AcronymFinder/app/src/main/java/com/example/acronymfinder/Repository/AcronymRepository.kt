package com.example.acronymfinder.Repository

import com.example.acronymfinder.model.Acronym

class AcronymRepository {
    private val acronymMeanings = mapOf(
        "NASA" to "National Aeronautics and Space Administration",
        "NATO" to "North Atlantic Treaty Organization",
        "AIDS" to "Acquired Immune Deficiency Syndrome"
    )

    fun getMeaning(acronym: String): Acronym {
        val meaning = acronymMeanings[acronym.toUpperCase()]
        return if (meaning != null) {
            Acronym(acronym, meaning)
        } else {
            Acronym(acronym, "Acronym not found")
        }
    }
}