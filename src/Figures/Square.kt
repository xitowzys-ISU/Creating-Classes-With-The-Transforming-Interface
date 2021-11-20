package Figures

import Figures.Interfaces.Transforming
import Figures.Enums.RotateDirection
import kotlin.math.pow

class Square(var x: Int, var y: Int, var width: Float) : Transforming, Figure(0) {
    override fun area(): Float {
        return width.pow(2)
    }

    override fun resize(zoom: Int) {
        width *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if (centerX == x && centerY == y) return
        val (signX, signY) = if (direction == RotateDirection.COUNTER_CLOCK_WISE) Pair(-1, 1) else Pair(1, -1)

        x = (signX * (y - centerY) + centerX).also {
            y = signY * (x - centerX) + centerY
        }
    }

    override fun toString(): String {
        return "Квадрат ($x, $y) [w: $width]"
    }
}