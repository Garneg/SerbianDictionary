package com.garnegsoft.serbiandictionary.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val CommonRetrofit = Retrofit.Builder()
	.addConverterFactory(GsonConverterFactory.create())
	.baseUrl("http://192.168.1.10/")
	.build()