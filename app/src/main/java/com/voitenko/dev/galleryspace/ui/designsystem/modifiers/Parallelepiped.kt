package com.voitenko.dev.galleryspace.ui.designsystem.modifiers

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import com.voitenko.dev.galleryspace.ui.designsystem.crystal

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
fun Modifier.parallelepiped(
    angleX: Float,
    angleY: Float,
    sideColor: Color = crystal,
    faceColor: Color = Color.Black,
): Modifier = then(Modifier.drawWithContent {

    fun Path.draw3d() {
        drawPath(path = this, color = sideColor, style = Fill)
        drawPath(path = this, color = faceColor, style = Stroke(width = 1F))
    }

    val sizeCoefficient = 1F
    val perspectiveCoefficient = 0.2F

    val angleFirst = angleX * sizeCoefficient
    val angleSecond = angleY * sizeCoefficient

    val contentWidth = size.width
    val contentHeight = size.height

    val rightPerspective =
        if (angleFirst < 0) kotlin.math.abs(angleFirst * perspectiveCoefficient) else 0f
    val leftPerspective =
        if (angleFirst > 0) kotlin.math.abs(angleFirst * perspectiveCoefficient) else 0f
    val topPerspective =
        if (angleSecond < 0) kotlin.math.abs(angleSecond * perspectiveCoefficient) else 0f
    val bottomPerspective =
        if (angleSecond > 0) kotlin.math.abs(angleSecond * perspectiveCoefficient) else 0f

    // TOP
    if (angleSecond < 0f) Path().apply {
        val leftHeight = (angleSecond + leftPerspective)
        val rightHeight = (angleSecond + rightPerspective)

        moveTo(x = 0f, y = 0f)
        lineTo(x = angleFirst, y = leftHeight)
        lineTo(x = contentWidth + angleFirst, y = rightHeight)
        lineTo(x = contentWidth, y = 0f)
        lineTo(x = 0f, y = 0f)
    }.draw3d()

    // BOTTOM
    if (angleSecond > 0f) Path().apply {
        val leftHeight = (contentHeight + angleSecond - leftPerspective)
        val rightHeight = (contentHeight + angleSecond - rightPerspective)

        moveTo(0f, contentHeight)
        lineTo(x = angleFirst, y = leftHeight)
        lineTo(x = contentWidth + angleFirst, y = rightHeight)
        lineTo(x = contentWidth, y = contentHeight)
        lineTo(x = 0f, y = contentHeight)
    }.draw3d()

    // LEFT
    if (angleFirst < 0f) Path().apply {
        val topWidth = (angleFirst + bottomPerspective)
        val bottomWidth = (angleFirst + topPerspective)

        moveTo(0f, 0f)
        lineTo(x = topWidth, y = angleSecond)
        lineTo(x = bottomWidth, y = contentHeight + angleSecond)
        lineTo(x = 0f, y = contentHeight)
        lineTo(x = 0f, y = 0f)
    }.draw3d()

    // RIGHT
    if (angleFirst > 0f) Path().apply {
        val topWidth = (contentWidth + angleFirst - bottomPerspective)
        val bottomWidth = (contentWidth + angleFirst - topPerspective)

        moveTo(contentWidth, 0f)
        lineTo(x = topWidth, y = angleSecond)
        lineTo(x = bottomWidth, y = contentHeight + angleSecond)
        lineTo(x = contentWidth, y = contentHeight)
        lineTo(x = contentWidth, y = 0f)
    }.draw3d()

    drawContent()
})