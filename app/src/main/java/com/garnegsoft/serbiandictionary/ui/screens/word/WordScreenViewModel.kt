package com.garnegsoft.serbiandictionary.ui.screens.word

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garnegsoft.serbiandictionary.retrofit.Word
import com.garnegsoft.serbiandictionary.retrofit.WordController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class WordScreenViewModel : ViewModel() {
	private val _word = MutableLiveData<Word>()
	val word: LiveData<Word> = _word
	
	fun loadWord(wordId: String) {
		viewModelScope.launch(Dispatchers.IO) {
			WordController.instance.getWord(wordId).execute().body()?.let {
				_word.postValue(it)
			}
		}
	}
}