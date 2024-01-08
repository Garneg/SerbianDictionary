package com.garnegsoft.serbiandictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.garnegsoft.serbiandictionary.retrofit.PromptsController
import com.garnegsoft.serbiandictionary.retrofit.WordController
import com.garnegsoft.serbiandictionary.ui.navigation.MainNavigationGraph
import com.garnegsoft.serbiandictionary.ui.theme.SerbianDictionaryTheme
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : ComponentActivity() {
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		WindowCompat.setDecorFitsSystemWindows(window, false)
		
		
		setContent {
			SerbianDictionaryTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					MainNavigationGraph()
				}
			}
		}
	}
}