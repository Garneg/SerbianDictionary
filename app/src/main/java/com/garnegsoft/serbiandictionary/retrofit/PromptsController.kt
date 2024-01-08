package com.garnegsoft.serbiandictionary.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query




interface PromptsController {
	@GET("/api/prompts")
	fun get(@Query("query") query: String): Call<List<Prompt>>
	
	companion object {
		val instance: PromptsController = CommonRetrofit.create(PromptsController::class.java)
	}
	
}

data class Prompt(
	val id: String,
	val text: String,
)