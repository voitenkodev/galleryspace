package com.voitenko.dev.galleryspace.ui.designsystem.modifiers

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import com.voitenko.dev.galleryspace.ui.designsystem.crystal

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
fun Modifier.parallelepiped(
    angleX: Float,
    angleY: Float,
    coefficient: Float = 1.0F,
    color: Color = Color.Gray,
): Modifier = composed {

    then(Modifier.drawWithContent {

        fun Path.draw3d(color: Color) {
            drawPath(path = this, color = color, style = Fill)
        }

        val angleFirst = angleX * coefficient
        val angleSecond = angleY * coefficient

        val contentWidth = size.width
        val contentHeight = size.height

        val coef = 0.2f

        val coefSize = 1f

        val rightPerspectiveOut =
            if (angleFirst < 0) kotlin.math.abs(angleFirst * coef) else 0f
        val leftPerspectiveOut =
            if (angleFirst > 0) kotlin.math.abs(angleFirst * coef) else 0f
        val topPerspectiveOut =
            if (angleSecond < 0) kotlin.math.abs(angleSecond * coef) else 0f
        val bottomPerspectiveOut =
            if (angleSecond > 0) kotlin.math.abs(angleSecond * coef) else 0f

        // TOP
        if (angleSecond < 0f) {
            Path().apply {
                val leftHeight = (angleSecond + leftPerspectiveOut) * coefSize
                val rightHeight = (angleSecond + rightPerspectiveOut) * coefSize

                moveTo(x = 0f, y = 0f)
                lineTo(x = angleFirst, y = leftHeight)
                lineTo(x = contentWidth + angleFirst, y = rightHeight)
                lineTo(x = contentWidth, y = 0f)
                lineTo(x = 0f, y = 0f)
            }.draw3d(color.copy(alpha = 0.6f))
        }

        // BOTTOM
        if (angleSecond > 0f) {
            Path().apply {
                val leftHeight = (contentHeight + angleSecond - leftPerspectiveOut) * coefSize
                val rightHeight = (contentHeight + angleSecond - rightPerspectiveOut) * coefSize

                moveTo(0f, contentHeight)
                lineTo(x = angleFirst, y = leftHeight)
                lineTo(x = contentWidth + angleFirst, y = rightHeight)
                lineTo(x = contentWidth, y = contentHeight)
                lineTo(x = 0f, y = contentHeight)
            }.draw3d(color.copy(alpha = 0.6f))
        }

        // LEFT
        if (angleFirst < 0f) {
            Path().apply {
                val topWidth = (angleFirst + bottomPerspectiveOut) * coefSize
                val bottomWidth = (angleFirst + topPerspectiveOut) * coefSize

                moveTo(0f, 0f)
                lineTo(x = topWidth, y = angleSecond)
                lineTo(x = bottomWidth, y = contentHeight + angleSecond)
                lineTo(x = 0f, y = contentHeight)
                lineTo(x = 0f, y = 0f)
            }.draw3d(color)
        }

        // RIGHT
        if (angleFirst > 0f) {
            Path().apply {
                val topWidth = (contentWidth + angleFirst - bottomPerspectiveOut) * coefSize
                val bottomWidth = (contentWidth + angleFirst - topPerspectiveOut) * coefSize

                moveTo(contentWidth, 0f)
                lineTo(x = topWidth, y = angleSecond)
                lineTo(x = bottomWidth, y = contentHeight + angleSecond)
                lineTo(x = contentWidth, y = contentHeight)
                lineTo(x = contentWidth, y = 0f)
            }.draw3d(color)
        }

        drawContent()
    })
}