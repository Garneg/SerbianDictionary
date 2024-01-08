package com.garnegsoft.serbiandictionary.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.garnegsoft.serbiandictionary.ui.navigation.entries.mainScreenNavEntry
import com.garnegsoft.serbiandictionary.ui.navigation.entries.searchScreenNavEntry
import com.garnegsoft.serbiandictionary.ui.navigation.entries.wordScreenNavEntry


@Composable
fun MainNavigationGraph(
	navController: NavHostController = rememberNavController()
) {
	val appNavController = remember { SDNavigationController(navController) }
	NavHost(
		navController = navController,
		startDestination = Screens.Main.route
	) {
		mainScreenNavEntry(appNavController)
		wordScreenNavEntry(appNavController)
		searchScreenNavEntry(appNavController)
	}
}