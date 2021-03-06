package com.voitenko.dev.designsystem.controls

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.voitenko.dev.designsystem.GallerySpaceComponent
import com.voitenko.dev.designsystem.common.GallerySpaceTheme

@Composable
fun H1Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.H1,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.primaryInverse,
    textAlign = textAlign,
)

@Composable
fun H2Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.H2,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.primaryInverse,
    textAlign = textAlign,
)

@Composable
fun BODY1Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.BODY1,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.primaryInverse,
    textAlign = textAlign,
)

@Composable
fun BODY2Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.BODY2,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.primaryInverse.copy(alpha = 0.6f),
    textAlign = textAlign,
)

@Composable
fun CAPTION1Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    placeholder = placeholder,
    textStyle = GallerySpaceComponent.typography.CAPTION1,
    maxLines = maxLines,
    color = color ?: GallerySpaceComponent.colors.caption,
    textAlign = textAlign,
)

@ExperimentalUnitApi
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, name = "H1")
@Composable
private fun H1_Preview() {
    GallerySpaceTheme {
        H1Text(text = "Text Helper")
    }
}

@ExperimentalUnitApi
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, name = "BODY1")
@Composable
private fun BODY1_Preview() {
    GallerySpaceTheme {
        BODY1Text(text = "Text Helper")
    }
}

@ExperimentalUnitApi
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, name = "BODY2")
@Composable
private fun BODY2_Preview() {
    GallerySpaceTheme {
        BODY2Text(text = "Text Helper")
    }
}

@ExperimentalUnitApi
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, name = "BUTTON2")
@Composable
private fun CAPTION2_Preview() {
    GallerySpaceTheme {
        CAPTION1Text(text = "Text Helper")
    }
}

@Composable
internal fun Text(
    modifier: Modifier = Modifier,
    text: String?,
    placeholder: String? = null,
    color: Color? = null,
    textAlign: TextAlign? = null,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
) {
    val isPlaceholder = text == null

    val _color = if (isPlaceholder) color?.copy(alpha = 0.7f) else color

    val innerColorTextStyle = if (_color != null) {
        textStyle.copy(color = _color)
    } else textStyle

    val innerTextAlignTextStyle = if (textAlign != null) {
        innerColorTextStyle.copy(textAlign = textAlign)
    } else innerColorTextStyle

    BasicText(
        modifier = modifier,
        text = text ?: placeholder ?: "",
        style = innerTextAlignTextStyle,
        maxLines = maxLines
    )
}