package com.voitenko.dev.galleryspace.newart

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.voitenko.dev.designsystem.controls.BODY1EditText
import com.voitenko.dev.designsystem.controls.BODY1Text
import com.voitenko.dev.designsystem.controls.Divider

@Composable
fun NewArtScreen(navController: NavController) {

    val description = remember { mutableStateOf(TextFieldValue()) }

    LazyColumn {
        item {
            Box(
                modifier = Modifier.aspectRatio(1f),
                contentAlignment = Alignment.Center,
            ) {

                Image(
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize(), imageVector = Icons.Default.Info, contentDescription = null
                )
            }

        }
        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            val value = remember { mutableStateOf(TextFieldValue()) }

            BODY1EditText(
                text = value.value,
                onValueChange = { value.value = it },
                label = "Put a title of image",
            )
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            val value = remember { mutableStateOf<String?>(null) }
            Info(
                modifier = Modifier.padding(horizontal = 16.dp),
                caption = "Put a date",
                placeholder = "00, Jan, 0000",
                value = value.value,
                onClick = { value.value = "16, Sep, 1994" }
            )
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            val value = remember { mutableStateOf<String?>(null) }
            Info(
                modifier = Modifier.padding(horizontal = 16.dp),
                caption = "Put a price",
                placeholder = "--- $",
                value = value.value,
                onClick = { value.value = "200 $" }
            )
        }

        item { Divider(modifier = Modifier.padding(horizontal = 16.dp)) }

        item {
            BODY1EditText(
                text = description.value,
                onValueChange = { description.value = it },
                label = "Put a description",
            )
        }
    }
}

@Composable
private fun Info(
    modifier: Modifier = Modifier,
    caption: String,
    placeholder: String?,
    value: String?,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .defaultMinSize(minHeight = 44.dp)
            .fillMaxWidth()
            .clickable { onClick.invoke() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        BODY1Text(modifier = Modifier.weight(1f), text = caption)
        BODY1Text(placeholder = placeholder, text = value)
    }
}