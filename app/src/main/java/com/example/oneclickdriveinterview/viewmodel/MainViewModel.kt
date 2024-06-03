package com.example.oneclickdriveinterview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(val set1 : List<String>,val set2 : List<String>,val set3 : List<String>):ViewModel() {

}

class MainViewModelFactory(val set1 : List<String>,val set2 : List<String>,val set3 : List<String>):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(set1, set2,set3) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}