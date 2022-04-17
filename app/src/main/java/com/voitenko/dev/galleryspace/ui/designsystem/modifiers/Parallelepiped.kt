package com.voitenko.dev.galleryspace.ui.designsystem.modifiers

import android.view.MotionEvent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
fun Modifier.parallelepiped(): Modifier = composed {

    val fillColor = Color(0xFF4D2300)
    val strokeColor = Color(0xFF421F02)

    var angle by remember { mutableStateOf(Pair(0f, 0f)) }
    var start by remember { mutableStateOf(Pair(-1f, -1f)) }
    var viewSize by remember { mutableStateOf(Size.Zero) }

    this.then(Modifier
        .onGloballyPositioned { coordinates ->
            viewSize = Size(
                width = coordinates.size.width.toFloat(),
                height = coordinates.size.height.toFloat()
            )
        }
        .pointerInteropFilter { m ->
            when (m.action) {
                MotionEvent.ACTION_UP -> {
                    start = Pair(-1f, -1f)
                }
                MotionEvent.ACTION_DOWN -> {
                    start = Pair(m.rawX, m.rawY)
                }
                MotionEvent.ACTION_MOVE -> {
                    if (viewSize != Size.Zero) {
                        val end = Pair(m.rawX, m.rawY)
                        val newAngle = getRotationAngles(start, end, viewSize)
                        var x: Float = angle.first + newAngle.first
                        var y: Float = angle.second + newAngle.second
                        if (x > maxAngle) x = maxAngle
                        else if (x < -maxAngle) x = -maxAngle
                        if (y > maxAngle) y = maxAngle
                        else if (y < -maxAngle) y = -maxAngle
                        angle = Pair(x, y)
                        start = end
                    }
                }
            }
            true
        }
        .graphicsLayer(
            transformOrigin = TransformOrigin(0.5f, 0.5f),
            rotationY = animateFloatAsState(-angle.first).value,
            rotationX = animateFloatAsState(angle.second).value,
            cameraDistance = 16.dp.value
        )
        .drawWithContent {
            drawContent()

            fun Path.draw3d() {
                drawPath(
                    path = this, color = fillColor, style = Fill
                )
                drawPath(
                    path = this, color = strokeColor, style = Stroke(width = 2F)
                )
            }

            val k = 1F
            val angleFirst = angle.first * k
            val angleSecond = angle.second * k
            val constWidth = this.size.width
            val constHeight = this.size.height

            // TOP
            if (angle.second < 0f) Path()
                .apply {
                    this.moveTo(0f, 0f)
                    this.lineTo(x = angleFirst, y = angleSecond)
                    this.lineTo(x = constWidth + angleFirst, y = angleSecond)
                    this.lineTo(x = constWidth, y = 0f)
                    this.lineTo(x = 0f, y = 0f)
                }
                .draw3d()

            // BOTTOM
            if (angle.second > 0f) Path()
                .apply {
                    this.moveTo(0f, constHeight)
                    this.lineTo(x = angleFirst, y = constHeight + angleSecond)
                    this.lineTo(x = constWidth + angleFirst, y = constHeight + angleSecond)
                    this.lineTo(x = constWidth, y = constHeight)
                    this.lineTo(x = 0f, y = constHeight)
                }
                .draw3d()

            // LEFT
            if (angle.first < 0f) Path()
                .apply {
                    this.moveTo(0f, 0f)
                    this.lineTo(x = angleFirst, y = angleSecond)
                    this.lineTo(x = angleFirst, y = constHeight + angleSecond)
                    this.lineTo(x = 0f, y = constHeight)
                    this.lineTo(x = 0f, y = 0f)
                }
                .draw3d()

            // RIGHT
            if (angle.first > 0f) Path()
                .apply {
                    this.moveTo(constWidth, 0f)
                    this.lineTo(x = constWidth + angleFirst, y = angleSecond)
                    this.lineTo(x = constWidth + angleFirst, y = constHeight + angleSecond)
                    this.lineTo(x = constWidth, y = constHeight)
                    this.lineTo(x = constWidth, y = 0f)
                }
                .draw3d()

        })
}

private fun getRotationAngles(
    start: Pair<Float, Float>, end: Pair<Float, Float>, size: Size
): Pair<Float, Float> {
    val acceleration = 3
    val distances = getDistances(end, start)
    val rotationX = (distances.first / size.width) * maxAngle * acceleration
    val rotationY = (distances.second / size.height) * maxAngle * acceleration
    return Pair(rotationX, rotationY)
}

private fun getDistances(p1: Pair<Float, Float>, p2: Pair<Float, Float>): Pair<Float, Float> {
    return Pair(
        p2.first - p1.first, p2.second - p1.second
    )
}

private const val maxAngle = 50f