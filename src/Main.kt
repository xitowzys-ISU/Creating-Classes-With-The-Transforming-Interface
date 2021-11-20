import Figures.*
import Figures.Enums.RotateDirection
import Figures.Interfaces.Transforming

fun checkMethods(
    figureName: String,
    obj: Transforming,
    resize: Int,
    rDirection: RotateDirection = RotateDirection.CLOCK_WISE,
    CenterX: Int = 0,
    CenterY: Int = 0
) {
    println("$figureName перед resize(2): $obj")
    obj.resize(2)
    println("$figureName после resize(2): $obj")

    println("-".repeat(150))

    println("$figureName перед rotate(Figures.Enums.RotateDirection.Clockwise, 0, 0): $obj")
    obj.rotate(rDirection, CenterX, CenterY)
    println("$figureName после rotate(Figures.Enums.RotateDirection.Clockwise, 0, 0): $obj")

    println("*".repeat(150))
}

fun main() {
    val tr: Transforming = Rect(0, 3, 1f, 2f)
    checkMethods(figureName = "Прямоугольник", obj = tr, resize = 2)

    val tc: Transforming = Circle(3f, 0, 0)
    checkMethods(
        figureName = "Круг",
        obj = tc,
        resize = 2,
        rDirection = RotateDirection.COUNTER_CLOCK_WISE,
        CenterY = 3
    )

    val ts: Transforming = Square(0, 3, 5f)
    checkMethods(figureName = "Квадрат", obj = ts, resize = 2, CenterX = 3)
}