class SquareHole(private val sideLength: Double) {

    fun canFit(square: Square): Boolean {
        return sideLength >= square.sideLength
    }
}

open class Square(open val sideLength: Double = 0.0)

class Circle(private val radius: Double) {

    fun getRadius(): Double {
        return radius
    }
}

class CircleToSquareAdapter(private val circle: Circle) : Square() {

    override val sideLength: Double
        get() = 2 * circle.getRadius() // diameter of circle
}