package com.garnegsoft.serbiandictionary.ui.navigation.entries

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.garnegsoft.serbiandictionary.ui.navigation.SDNavigationController
import com.garnegsoft.serbiandictionary.ui.navigation.Screens
import com.garnegsoft.serbiandictionary.ui.screens.word.WordScreen


fun NavGraphBuilder.wordScreenNavEntry(
	navController: SDNavigationController
) {
	composable(Screens.WordScreen.fullRoute) {
		val wordId = it.arguments?.getString("wordId")
		val wordText = it.arguments?.getString("wordText")

		WordScreen(
			onBack = {
				navController.navigateBack()
			},
			wordId = wordId!!,
			title = wordText!!
		)
	}
}