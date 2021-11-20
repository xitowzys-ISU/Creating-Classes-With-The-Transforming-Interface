package Figures.Interfaces

import Figures.Enums.RotateDirection

interface Transforming {
    fun resize(zoom: Int)

    fun rotate(direction: RotateDirection, centerX: Int, centerY: Int)
}