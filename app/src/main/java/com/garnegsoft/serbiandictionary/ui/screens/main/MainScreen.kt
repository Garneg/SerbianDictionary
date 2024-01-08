package com.garnegsoft.serbiandictionary.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.garnegsoft.serbiandictionary.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
	onBack: () -> Unit,
	onSearchBarClick: () -> Unit
) {
	Scaffold(
		modifier = Modifier.imePadding(),
		topBar = {
			TopAppBar(title = { Text(text = stringResource(id = R.string.main_screen_title)) })
		}
	) {
		
		Column(
			modifier = Modifier
				.imePadding()
				.fillMaxSize()
				.padding(it)
				.padding(horizontal = 32.dp)
				.padding(bottom = 8.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Spacer(modifier = Modifier.fillMaxHeight(0.25f))
			var textFieldValue by remember {
				mutableStateOf("")
			}
			BasicTextField(
				modifier = Modifier.pointerInput(Unit) {
					onSearchBarClick()
				},
				value = textFieldValue,
				onValueChange = {
					textFieldValue = it
				},
				singleLine = true,
				cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface),
				textStyle = MaterialTheme.typography.bodyLarge.copy(
					MaterialTheme.colorScheme.onSurface
				)
			) {
				Row(
					modifier = Modifier
						.fillMaxWidth()
						.clip(CircleShape)
						.background(MaterialTheme.colorScheme.primaryContainer)
						.padding(8.dp)
						.padding(start = 8.dp),
					verticalAlignment = Alignment.CenterVertically
				) {
					
					Box(Modifier.weight(1f)) {
						if (textFieldValue.isEmpty()) {
							Text(
								text = stringResource(id = R.string.search_text_field_hint),
								style = MaterialTheme.typography.bodyLarge.copy(
									MaterialTheme.colorScheme.onSurfaceVariant
								)
							)
						}
						it()
					}
					IconButton(
						onClick = { /*TODO*/ },
						colors = IconButtonDefaults.iconButtonColors(
							contentColor = MaterialTheme.colorScheme.onSurface,
							disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
						),
						enabled = textFieldValue.isNotBlank()
					) {
						Icon(
							imageVector = Icons.Default.Search, contentDescription = null
						)
					}
				}
			}
			Spacer(modifier = Modifier.height(8.dp))
			if (textFieldValue.length > 0) {
				Column(
					modifier = Modifier
						
						.clip(RoundedCornerShape(30.dp))
						.background(MaterialTheme.colorScheme.primaryContainer)
						.fillMaxWidth()
						.verticalScroll(rememberScrollState())
					//.padding(vertical = 8.dp)
				
				) {
					repeat(5) {
						AutocompleteListItem(title = "Stan " + it, onClick = { /*TODO*/ })
//					Divider(
//						modifier = Modifier.padding(horizontal = 64.dp),
//						color = MaterialTheme.colorScheme.onPrimaryContainer.copy(0.1f))
					}
					
				}
			} else {
				Row(
					horizontalArrangement = Arrangement.spacedBy(8.dp)
				) {
					FilledTonalButton(
						modifier = Modifier.weight(1f),
						onClick = { /*TODO*/ }
					) {
						Text(text = "По алфавиту")
					}
					FilledTonalButton(
						modifier = Modifier.weight(1f),
						onClick = { /*TODO*/ }
					) {
						Text(text = "Случайное")
					}
				}
			}
			
		}
	}
}

@Composable
fun AutocompleteListItem(
	title: String,
	onClick: () -> Unit,
	matchText: String? = null
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.clickable(onClick = onClick)
			.padding(horizontal = 16.dp, vertical = 20.dp)
	) {
		Text(text = title)
	}
}