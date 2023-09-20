package com.garnegsoft.serbiandictionary.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.garnegsoft.serbiandictionary.ui.theme.SerbianDictionaryTheme


@Preview(locale = "ru",
	uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
	showSystemUi = true, device = "id:pixel_2"
)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun WordScreen() {
	SerbianDictionaryTheme {
		Scaffold(
			topBar = {
				TopAppBar(
					title = { Text("Stan")},
					navigationIcon = {
						IconButton(onClick = { /*TODO*/ }) {
							Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
						}
					}
				
				)
			}
		) {
			Column(
				modifier = Modifier
					.padding(it)
					.verticalScroll(rememberScrollState())
					.padding(16.dp)
			) {
				Row(
					verticalAlignment = Alignment.Bottom
				) {
					Text(
						text = "Stan",
						style = MaterialTheme.typography.displayMedium
					)
					Text(
						modifier = Modifier
							.padding(bottom = 8.dp),
						text = " (рус. Квартира)", color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
				}
				
				Divider(Modifier.padding(vertical = 12.dp))
				
				Text(text = "Существительное. Мужской род")
				
				Spacer(modifier = Modifier.height(16.dp))
				
				Text(text = "Значение",
					style = MaterialTheme.typography.headlineSmall)
				Spacer(modifier = Modifier.height(2.dp))
				Text(text = "Дом, место жительства, комната для проживания")
				
				Spacer(modifier = Modifier.height(16.dp))
				
				Text(text = "Примеры",
					style = MaterialTheme.typography.headlineSmall)
				Spacer(modifier = Modifier.height(2.dp))
				BulletList(
					items = listOf(
						"Ja radim u stanu kad sta zelim. Ovo je vrlo dobro!",
						"Ne skacem i ne trcim po stanu, ne pustam glasnu muziku...",
						"Reci mi jedan razlog prednosti stana na Vracaru..."
					)
				)
				
				Spacer(modifier = Modifier.height(16.dp))
				
				Text(text = "Синонимы",
					style = MaterialTheme.typography.headlineSmall)
				Spacer(modifier = Modifier.height(2.dp))
				
				FlowRow(
					verticalArrangement = Arrangement.spacedBy(4.dp),
					horizontalArrangement = Arrangement.spacedBy(8.dp)
				) {
					FilledTonalButton(onClick = { /*TODO*/ }) {
						Text(text = "Kuca")
					}
					FilledTonalButton(onClick = { /*TODO*/ }) {
						Text(text = "Dom")
					}
					FilledTonalButton(onClick = { /*TODO*/ }) {
						Text(text = "Sediste")
					}
					FilledTonalButton(onClick = { /*TODO*/ }) {
						Text(text = "Kodan")
					}
				}
				
			}
		}
	}
	
}

@Composable
fun BulletList(
	items: List<String>,
	modifier: Modifier = Modifier,
	verticalArranement: Arrangement.Vertical = Arrangement.spacedBy(4.dp),
	item: @Composable (String) -> Unit = {
		Text(text = it)
	}
) {
	Column(
		modifier = modifier,
		verticalArrangement = verticalArranement
	) {
		items.forEach {
			Row {
				Text(text = "● ")
				item(it)
			}
		}
	}
}