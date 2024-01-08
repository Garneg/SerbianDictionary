package com.garnegsoft.serbiandictionary.ui.screens.search


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garnegsoft.serbiandictionary.retrofit.Prompt
import com.garnegsoft.serbiandictionary.retrofit.PromptsController
import com.garnegsoft.serbiandictionary.retrofit.SearchController
import com.garnegsoft.serbiandictionary.retrofit.SearchResult
import com.garnegsoft.serbiandictionary.retrofit.WordController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SearchScreenViewModel : ViewModel() {
	
	private val _prompts = MutableLiveData<List<Prompt>>()
	val prompts: LiveData<List<Prompt>> = _prompts
	
	private val _serachResults = MutableLiveData<List<SearchResult>>()
	val searchResults: LiveData<List<SearchResult>> = _serachResults
	
	fun getPrompts(query: String) {
		viewModelScope.launch(Dispatchers.IO) {
			PromptsController.instance.get(query).execute().body()?.let {
				_prompts.postValue(it)
			} ?: clearPromptsList()
		}
	}
	
	fun search(query: String) {
		viewModelScope.launch(Dispatchers.IO) {
			SearchController.instance.search(query).execute().body()?.let {
				_serachResults.postValue(it)
			}
		}
	}
	
	fun clearPromptsList() {
		_prompts.postValue(emptyList())
	}
}