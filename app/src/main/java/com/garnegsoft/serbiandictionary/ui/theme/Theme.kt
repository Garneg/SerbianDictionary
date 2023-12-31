package com.garnegsoft.serbiandictionary.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
	primary = Color(0xFFB1CC44),
	secondary = Color(0xFFDCF186),
	tertiary = Color(0xFF9AAC50),
	surface = Color(0xFF3D3F37),
	background = Color(0xFF252523),
	onSurface = Color(0xFFF4F7EC),
	onSurfaceVariant = Color(0xFFC1C5B6),
	secondaryContainer = Color(0xFF31332C),
	onSecondaryContainer = Color(0xFFE9ECE1)
)

private val LightColorScheme = lightColorScheme(
	primary = Color(0xFFC1E045),
	secondary = Color(0xFFDCF186),
	tertiary = Color(0xFFA3C90B),
	background = Color(0xFFFCFFF2),
	surface = Color(0xFFEDF5C9),
	onSurface = Color(0xFF4A522D),
	onSurfaceVariant = Color(0xFF7B806B),
	secondaryContainer = Color(0xFFF0F5D7),
	onSecondaryContainer = Color(0xFF4A522D),
	outline = Color(0xD5697447),
	outlineVariant = Color(0xCCAAB38F),
	primaryContainer = Color(0xFFEDF3CE),
	onPrimaryContainer = Color(0xFF454D21)
	/* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun SerbianDictionaryTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	// Dynamic color is available on Android 12+
	dynamicColor: Boolean = true,
	content: @Composable () -> Unit
) {
	val colorScheme = when {
		dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
			val context = LocalContext.current
			if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
		}
		
		darkTheme -> DarkColorScheme
		else -> LightColorScheme
	}
	
	val view = LocalView.current
	if (!view.isInEditMode) {
		SideEffect {
			val window = (view.context as Activity).window
			window.statusBarColor = Color.Transparent.toArgb()
			WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
		}
	}
	
	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		content = content
	)
}