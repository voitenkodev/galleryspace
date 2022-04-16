package com.voitenko.dev.galleryspace.ui.designsystem.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.voitenko.dev.galleryspace.ui.designsystem.GallerySpaceComponent
import com.voitenko.dev.galleryspace.ui.designsystem.GallerySpaceTheme

@Composable
fun H1Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    textStyle = GallerySpaceComponent.typography.H1,
    maxLines = maxLines,
    color = color,
    textAlign = textAlign,
)

@Composable
fun H2Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    textStyle = GallerySpaceComponent.typography.H2,
    maxLines = maxLines,
    color = color,
    textAlign = textAlign,
)

@Composable
fun H3Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    textStyle = GallerySpaceComponent.typography.H2,
    maxLines = maxLines,
    color = color,
    textAlign = textAlign,
)

@Composable
fun BODY1Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    textStyle = GallerySpaceComponent.typography.BODY1,
    maxLines = maxLines,
    color = color,
    textAlign = textAlign,
)

@Composable
fun BODY2Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    textStyle = GallerySpaceComponent.typography.BODY2,
    maxLines = maxLines,
    color = color,
    textAlign = textAlign,
)

@Composable
fun BODY3Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    textStyle = GallerySpaceComponent.typography.BODY3,
    maxLines = maxLines,
    color = color,
    textAlign = textAlign,
)

@Composable
fun BUTTON1Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    textStyle = GallerySpaceComponent.typography.BUTTON1,
    maxLines = maxLines,
    color = color,
    textAlign = textAlign,
)

@Composable
fun BUTTON2Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) = Text(
    modifier = modifier,
    text = text,
    textStyle = GallerySpaceComponent.typography.BUTTON1,
    maxLines = maxLines,
    color = color,
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
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, name = "H2")
@Composable
private fun H2_Preview() {
    GallerySpaceTheme {
        H2Text(text = "Text Helper")
    }
}

@ExperimentalUnitApi
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, name = "H3")
@Composable
private fun H3_Preview() {
    GallerySpaceTheme {
        H3Text(text = "Text Helper")
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
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, name = "BODY3")
@Composable
private fun BODY3_Preview() {
    GallerySpaceTheme {
        BODY3Text(text = "Text Helper")
    }
}

@ExperimentalUnitApi
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, name = "BUTTON1")
@Composable
private fun BUTTON1_Preview() {
    GallerySpaceTheme {
        BUTTON1Text(text = "Text Helper")
    }
}

@ExperimentalUnitApi
@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, name = "BUTTON2")
@Composable
private fun BUTTON2_Preview() {
    GallerySpaceTheme {
        BUTTON2Text(text = "Text Helper")
    }
}

@Composable
private fun Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color? = null,
    textAlign: TextAlign? = null,
    textStyle: TextStyle,
    maxLines: Int = Int.MAX_VALUE,
) {
    val innerColorTextStyle = if (color != null) {
        textStyle.copy(color = color)
    } else textStyle

    val innerTextAlignTextStyle = if (textAlign != null) {
        innerColorTextStyle.copy(textAlign = textAlign)
    } else innerColorTextStyle


    BasicText(modifier = modifier,
        text = text,
        style = innerTextAlignTextStyle,
        maxLines = maxLines,
        onTextLayout = { tl: TextLayoutResult -> })
}


@Composable
private fun Inner(style: TextStyle, text: String) = ProvideTextStyle(value = style) {
    androidx.compose.material.Text(modifier = Modifier.alpha(0.6f), text = text, maxLines = 1)
}