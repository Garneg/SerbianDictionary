package com.garnegsoft.serbiandictionary.ui.navigation.entries

import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.garnegsoft.serbiandictionary.ui.navigation.SDNavigationController
import com.garnegsoft.serbiandictionary.ui.navigation.Screens
import com.garnegsoft.serbiandictionary.ui.screens.search.SearchScreen


fun NavGraphBuilder.searchScreenNavEntry(navController: SDNavigationController) {
	composable(
		route = Screens.Search.fullRoute,
		enterTransition = {
			slideIn { IntOffset(0, it.height / 4) } +
				fadeIn()
		}
	){
		SearchScreen(
			onBack = { navController.navigateBack() },
			onPromptClick = { text, id ->
				navController.navigateToWordScreen(id, text)
			})
		
	}
}