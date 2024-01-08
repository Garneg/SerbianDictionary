package com.garnegsoft.serbiandictionary.ui.navigation

open class Screens(
	val route: String,
	val args: String = ""
) {
	/**
	 * Full route with args, should be used in navigation entry declaration
	 */
	val fullRoute: String = route + args
	
	
	object Main : Screens("main")
	
	object WordScreen : Screens("word", "/{wordId}?wordText={wordText}")
	
	object Search : Screens("search")
}

