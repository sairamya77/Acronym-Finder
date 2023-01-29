package com.example.acronymfinder.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.acronymfinder.Repository.AcronymRepository
import com.example.acronymfinder.model.Acronym

class AcronymViewModel (private val repository: AcronymRepository) : ViewModel() {
    val acronym = MutableLiveData<Acronym>()

    fun getMeaning(acronym: String) {
        this.acronym.value = repository.getMeaning(acronym)
    }
}