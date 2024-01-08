package com.garnegsoft.serbiandictionary.ui.navigation

import androidx.navigation.NavController


class SDNavigationController(
	val navController: NavController
) {
	fun navigateBack() {
		navController.popBackStack()
	}
	
	fun navigateToMainScreen() {
		navController.navigate(Screens.Main.route)
	}
	
	fun navigateToWordScreen(wordId: String, wordText: String? = null) {
		navController.navigate(Screens.WordScreen.route + "/$wordId?wordText=$wordText")
	}
	
	fun navigateToSearchScreen() {
		navController.navigate(Screens.Search.route)
	}
}

