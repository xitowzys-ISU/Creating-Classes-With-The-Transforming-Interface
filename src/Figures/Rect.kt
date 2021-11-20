package Figures

import Figures.Interfaces.Movable
import Figures.Interfaces.Transforming
import Figures.Enums.RotateDirection

class Rect(var x: Int, var y: Int, var width: Float, var height: Float) : Movable, Transforming, Figure(0) {

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun area(): Float {
        return width * height
    }

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if (centerX == x && centerY == y) return

        val (signX, signY) = if (direction == RotateDirection.COUNTER_CLOCK_WISE) Pair(-1, 1) else Pair(1, -1)

        x = (signX * (y - centerY) + centerX).also {
            y = signY * (x - centerX) + centerY
        }

        width = height.also {
            height = width
        }
    }

    override fun toString(): String {
        return "Прямоугольник ($x, $y) [w: $width, h: $height]"
    }
}