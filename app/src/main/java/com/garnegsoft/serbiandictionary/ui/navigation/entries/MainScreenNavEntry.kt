package com.garnegsoft.serbiandictionary.ui.navigation.entries

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.garnegsoft.serbiandictionary.ui.navigation.SDNavigationController
import com.garnegsoft.serbiandictionary.ui.navigation.Screens
import com.garnegsoft.serbiandictionary.ui.screens.main.MainScreen


internal fun NavGraphBuilder.mainScreenNavEntry(navController: SDNavigationController) {
	composable(Screens.Main.fullRoute) {
		MainScreen(
			onBack = {
				navController.navigateBack()
			},
			onSearchBarClick = {
				navController.navigateToSearchScreen()
			}
		)
	}
}