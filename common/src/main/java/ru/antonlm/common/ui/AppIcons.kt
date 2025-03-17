package ru.antonlm.common.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object AppIcons {
    private var _DefaultPlaceholder: ImageVector? = null

    val DefaultPlaceholder: ImageVector
        get() {
            if (_DefaultPlaceholder != null) {
                return _DefaultPlaceholder!!
            }
            _DefaultPlaceholder = ImageVector.Builder(
                name = "ru.antonlm.common.ui.icons.getDefaultPlaceholder",
                defaultWidth = 800.dp,
                defaultHeight = 800.dp,
                viewportWidth = 120f,
                viewportHeight = 120f
            ).apply {
                path(
                    fill = SolidColor(Color(0xFFEFF1F3)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.NonZero
                ) {
                    moveTo(0f, 0f)
                    horizontalLineTo(120f)
                    verticalLineTo(120f)
                    horizontalLineTo(0f)
                    verticalLineTo(0f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF687787)),
                    fillAlpha = 1.0f,
                    stroke = null,
                    strokeAlpha = 1.0f,
                    strokeLineWidth = 1.0f,
                    strokeLineCap = StrokeCap.Butt,
                    strokeLineJoin = StrokeJoin.Miter,
                    strokeLineMiter = 1.0f,
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(33.2503f, 38.4816f)
                    curveTo(33.26030f, 37.04720f, 34.41990f, 35.88640f, 35.85430f, 35.8750f)
                    horizontalLineTo(83.1463f)
                    curveTo(84.58480f, 35.8750f, 85.75030f, 37.04310f, 85.75030f, 38.48160f)
                    verticalLineTo(80.5184f)
                    curveTo(85.74030f, 81.95280f, 84.58070f, 83.11360f, 83.14630f, 83.1250f)
                    horizontalLineTo(35.8543f)
                    curveTo(34.41580f, 83.12360f, 33.25030f, 81.9570f, 33.25030f, 80.51840f)
                    verticalLineTo(38.4816f)
                    close()
                    moveTo(80.5006f, 41.1251f)
                    horizontalLineTo(38.5006f)
                    verticalLineTo(77.8751f)
                    lineTo(62.8921f, 53.4783f)
                    curveTo(63.91720f, 52.45360f, 65.57880f, 52.45360f, 66.60390f, 53.47830f)
                    lineTo(80.5006f, 67.4013f)
                    verticalLineTo(41.1251f)
                    close()
                    moveTo(43.75f, 51.6249f)
                    curveTo(43.750f, 54.52440f, 46.10050f, 56.87490f, 490f, 56.87490f)
                    curveTo(51.89950f, 56.87490f, 54.250f, 54.52440f, 54.250f, 51.62490f)
                    curveTo(54.250f, 48.72540f, 51.89950f, 46.37490f, 490f, 46.37490f)
                    curveTo(46.10050f, 46.37490f, 43.750f, 48.72540f, 43.750f, 51.62490f)
                    close()
                }
            }.build()
            return _DefaultPlaceholder!!
        }
}
