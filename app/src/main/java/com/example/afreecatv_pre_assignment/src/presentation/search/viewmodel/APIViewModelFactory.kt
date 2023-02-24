package com.example.afreecatv_pre_assignment.src.presentation.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.afreecatv_pre_assignment.src.data.model.GithubRepository

class APIViewModelFactory(private val repository : GithubRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GithubRepository::class.java).newInstance(repository)
    }
}