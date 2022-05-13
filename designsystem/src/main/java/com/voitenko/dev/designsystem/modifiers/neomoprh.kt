package com.voitenko.dev.designsystem.modifiers

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.neu(
    radius: Dp = 0.dp,
    pressed: Boolean = false,
    shadow1: Color = Color.Gray,
    shadow2: Color = Color.White,
    elevation: Dp = 4.dp
) = this.then(object : DrawModifier {

    override fun ContentDrawScope.draw() {
        if (pressed) drawForeground(radius, shadow1, shadow2, elevation)
        else drawBackground(radius, shadow1, shadow2, elevation)
        drawContent()
    }

    fun ContentDrawScope.drawBackground(
        radius: Dp,
        shadow1: Color,
        shadow2: Color,
        elevation: Dp
    ) = drawIntoCanvas { canvas ->
        val elevationPx = elevation.toPx()
        val blurRadius = elevationPx * .95f
        val displacement = elevationPx * .6f
        val dark = shadow1.toArgb()
        val light = shadow2.toArgb()

        val paintDark = Paint().also { p ->
            p.asFrameworkPaint().also {
                it.isAntiAlias = true
                it.isDither = true
                it.color = dark
                it.maskFilter = BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.NORMAL)
            }
        }

        val paintLight = Paint().also { p ->
            p.asFrameworkPaint().also {
                it.isAntiAlias = true
                it.isDither = true
                it.color = light
                it.maskFilter = BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.NORMAL)
            }
        }
        val backgroundDarkOffset = Offset(displacement, displacement)
        val backgroundLightOffset = Offset(-displacement, -displacement)

        canvas.save()
        canvas.translate(backgroundLightOffset.x, backgroundLightOffset.y)
        canvas.drawRoundRect(
            0f, 0f, size.width, size.height, radius.toPx(), radius.toPx(), paintLight
        )
        canvas.restore()
        canvas.save()
        canvas.translate(backgroundDarkOffset.x, backgroundDarkOffset.y)
        canvas.drawRoundRect(
            0f, 0f, size.width, size.height, radius.toPx(), radius.toPx(), paintDark
        )
        canvas.restore()
    }

    private fun ContentDrawScope.drawForeground(
        radius: Dp, shadow1: Color, shadow2: Color, elevation: Dp
    ) = drawIntoCanvas { canvas ->
        val elevationPx = elevation.toPx()
        val dark = shadow1.toArgb()
        val light = shadow2.toArgb()
        val blurRadius = elevationPx * 0.6f
        val strokeWidth = elevationPx * .95f
        val cornerRadius = radius.toPx()

        val paintDark = Paint().also { p ->
            p.asFrameworkPaint().also { nativePaint ->
                nativePaint.isAntiAlias = true
                nativePaint.color = dark
                nativePaint.strokeWidth = strokeWidth
                nativePaint.style = android.graphics.Paint.Style.STROKE
                nativePaint.maskFilter = BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.NORMAL)
            }
        }
        val paintLight = Paint().also { p ->
            p.asFrameworkPaint().also { nativePaint ->
                nativePaint.isAntiAlias = true
                nativePaint.color = light
                nativePaint.strokeWidth = strokeWidth
                nativePaint.style = android.graphics.Paint.Style.STROKE
                nativePaint.maskFilter = BlurMaskFilter(blurRadius, BlurMaskFilter.Blur.NORMAL)
            }
        }
        val backgroundDarkOffset = Offset(strokeWidth, strokeWidth)
        val backgroundLightOffset = Offset(-strokeWidth, -strokeWidth)

        canvas.save()

        val visiblePath = Path().also { p ->
            p.moveTo(0f, 0f)
            p.addRoundRect(
                RoundRect(0f, 0f, size.width, size.height, cornerRadius, cornerRadius)
            )
        }

        canvas.clipPath(visiblePath)
        canvas.translate(backgroundDarkOffset.x, backgroundDarkOffset.y)
        canvas.drawRoundRect(
            -strokeWidth,
            -strokeWidth,
            this.size.width + strokeWidth,
            this.size.height + strokeWidth,
            cornerRadius,
            cornerRadius,
            paintDark
        )
        canvas.restore()

        canvas.save()

        val visiblePath2 = Path().also { p ->
            p.moveTo(0f, 0f)
            p.addRoundRect(
                RoundRect(0f, 0f, size.width, size.height, cornerRadius, cornerRadius)
            )
        }

        canvas.clipPath(visiblePath2)
        canvas.translate(backgroundLightOffset.x, backgroundLightOffset.y)
        canvas.drawRoundRect(
            -strokeWidth,
            -strokeWidth,
            size.width + strokeWidth,
            size.height + strokeWidth,
            cornerRadius,
            cornerRadius,
            paintLight
        )
        canvas.restore()
    }
})