package com.voitenko.dev.galleryspace.designsystem.modifiers

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
fun Modifier.parallelepiped(
    angleX: Float,
    angleY: Float,
    coefficient: Float = 1.0F,
): Modifier = composed {

    then(Modifier.drawWithContent {

        fun Path.draw3d(color: Color) {
            drawPath(path = this, color = color, style = Fill)
        }

        val angleFirst = angleX * coefficient
        val angleSecond = angleY * coefficient

        val contentWidth = size.width
        val contentHeight = size.height

        val coefProportion = 0.5f
        val coefSize = 0.5f
        val _angleFirst = angleFirst * coefSize
        val _angleSecond = angleSecond * coefSize

        val rightPerspectiveOut =
            if (_angleFirst < 0) kotlin.math.abs(_angleFirst * coefProportion) else 0f
        val leftPerspectiveOut =
            if (_angleFirst > 0) kotlin.math.abs(_angleFirst * coefProportion) else 0f
        val topPerspectiveOut =
            if (_angleSecond < 0) kotlin.math.abs(_angleSecond * coefProportion) else 0f
        val bottomPerspectiveOut =
            if (_angleSecond > 0) kotlin.math.abs(_angleSecond * coefProportion) else 0f

        // TOP
        if (_angleSecond < 0f) {
            Path().apply {
                val leftHeight = (_angleSecond + leftPerspectiveOut)
                val rightHeight = (_angleSecond + rightPerspectiveOut)

                moveTo(x = 0f, y = 0f)
                lineTo(x = _angleFirst, y = leftHeight)
                lineTo(x = contentWidth + _angleFirst, y = rightHeight)
                lineTo(x = contentWidth, y = 0f)
                lineTo(x = 0f, y = 0f)
            }.draw3d(Color.DarkGray)
        }

        // BOTTOM
        if (_angleSecond > 0f) {
            Path().apply {
                val leftHeight = (contentHeight + _angleSecond - leftPerspectiveOut)
                val rightHeight = (contentHeight + _angleSecond - rightPerspectiveOut)

                moveTo(0f, contentHeight)
                lineTo(x = _angleFirst, y = leftHeight)
                lineTo(x = contentWidth + _angleFirst, y = rightHeight)
                lineTo(x = contentWidth, y = contentHeight)
                lineTo(x = 0f, y = contentHeight)
            }.draw3d(Color.DarkGray)
        }

        // LEFT
        if (_angleFirst < 0f) {
            Path().apply {
                val topWidth = (_angleFirst + bottomPerspectiveOut)
                val bottomWidth = (_angleFirst + topPerspectiveOut)

                moveTo(0f, 0f)
                lineTo(x = topWidth, y = _angleSecond)
                lineTo(x = bottomWidth, y = contentHeight + _angleSecond)
                lineTo(x = 0f, y = contentHeight)
                lineTo(x = 0f, y = 0f)
            }.draw3d(Color.Black)
        }

        // RIGHT
        if (_angleFirst > 0f) {
            Path().apply {
                val topWidth = (contentWidth + _angleFirst - bottomPerspectiveOut)
                val bottomWidth = (contentWidth + _angleFirst - topPerspectiveOut)

                moveTo(contentWidth, 0f)
                lineTo(x = topWidth, y = _angleSecond)
                lineTo(x = bottomWidth, y = contentHeight + _angleSecond)
                lineTo(x = contentWidth, y = contentHeight)
                lineTo(x = contentWidth, y = 0f)
            }.draw3d(Color.Black)
        }

        drawContent()
    })
}