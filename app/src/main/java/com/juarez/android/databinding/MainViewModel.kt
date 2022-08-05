package com.juarez.android.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    private var _name = MutableLiveData("Jose")
    private var _lastName = MutableLiveData("Juarez")
    private var _likes = MutableLiveData(0)
    private var _items = MutableLiveData<List<Item>>(emptyList())

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes
    val items: LiveData<List<Item>> = _items

    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
        repository.doRequest()
        _items.value = listOf(
            Item(1, "item1"),
            Item(2, "item2"),
            Item(3, "item3"),
            Item(4, "item4"),
        )
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}