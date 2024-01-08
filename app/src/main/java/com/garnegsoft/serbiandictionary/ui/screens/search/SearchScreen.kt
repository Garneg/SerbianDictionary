package com.garnegsoft.serbiandictionary.ui.screens.search

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



@Composable
fun SearchScreen(
	onBack: () -> Unit,
	onPromptClick: (wordText: String, wordId: String) -> Unit
) {
	
	val viewModel = viewModel<SearchScreenViewModel>()
	val prompts by viewModel.prompts.observeAsState()
	
	Surface {
		Column(
			modifier = Modifier
				
				.fillMaxSize()
				.navigationBarsPadding()
				.safeContentPadding()
				.background(MaterialTheme.colorScheme.primaryContainer)
		) {
			val searchCoroutine = rememberCoroutineScope()
			var searchTextFieldValue by remember { mutableStateOf("") }
			val focusRequester = remember { FocusRequester() }
			LaunchedEffect(key1 = Unit, block ={
				focusRequester.requestFocus()
			})
			BasicTextField(
				modifier = Modifier
					.focusRequester(focusRequester),
				value = searchTextFieldValue,
				textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.onPrimaryContainer),
				onValueChange = {
					searchTextFieldValue = it
					searchCoroutine.launch {
						if (searchTextFieldValue.isEmpty()){
							viewModel.clearPromptsList()
						}
						delay(500)
						if (searchTextFieldValue == it && searchTextFieldValue.isNotBlank()) {
							viewModel.getPrompts(searchTextFieldValue.trim())
						}
					}
				},
				singleLine = true,
				decorationBox = {
					Box(
						modifier = Modifier
							.fillMaxWidth()
							.height(55.dp)
							.background(MaterialTheme.colorScheme.primaryContainer)
							.padding(12.dp)
							.padding(start = 48.dp),
						contentAlignment = Alignment.CenterStart
					) {
						it()
					}
				},
				cursorBrush = SolidColor(MaterialTheme.colorScheme.onPrimaryContainer)
			)
			
			Divider(modifier = Modifier.padding(horizontal = 12.dp))
			Column(
				modifier = Modifier
					.verticalScroll(rememberScrollState())
					.animateContentSize()
			) {
				prompts?.forEach {
					
					ListItem(
						modifier = Modifier.clickable {
							onPromptClick(it.text, it.id)
						},
						headlineContent = { Text(text = it.text, color = MaterialTheme.colorScheme.onPrimaryContainer) },
						colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.primaryContainer)
					)
				}
				
			}
			
		}
	}
}