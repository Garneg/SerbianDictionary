package com.garnegsoft.serbiandictionary.retrofit

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WordController {
	
	@GET("/api/word/{wordId}")
	fun getWord(@Path("wordId") wordId: String): Call<Word>
	
	companion object {
		val instance: WordController = CommonRetrofit.create(WordController::class.java)
	}
	
}

data class Word(
	val id: String,
	val text: String,
	@SerializedName("class")
	val `class`: String,
	val meanings: List<String>
)