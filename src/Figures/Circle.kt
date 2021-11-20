package Figures

import Figures.Enums.RotateDirection
import Figures.Interfaces.Transforming
import kotlin.math.pow
import kotlin.math.PI

class Circle(var radius: Float, var x: Int, var y: Int) : Transforming, Figure(0) {
    override fun area(): Float {
        return PI.toFloat() * radius.pow(4);
    }

    override fun resize(zoom: Int) {
        radius *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if (centerX == x && centerY == y) return
        val (signX, signY) = if (direction == RotateDirection.COUNTER_CLOCK_WISE) Pair(-1, 1) else Pair(1, -1)

        x = (signX * (y - centerY) + centerX).also {
            y = signY * (x - centerX) + centerY
        }
    }

    override fun toString(): String {
        return "Круг ($x, $y) [r: $radius]"
    }
}