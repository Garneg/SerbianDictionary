package com.garnegsoft.serbiandictionary.retrofit

import retrofit2.Call
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchController {
	
	@GET("/api/search")
	fun search(@Query("query") query: String): Call<List<SearchResult>>
	
	companion object {
		val instance = CommonRetrofit.create(SearchController::class.java)
	}
}

data class SearchResult(
	val text: String,
	val `class`: String,
	val wordId: String
)