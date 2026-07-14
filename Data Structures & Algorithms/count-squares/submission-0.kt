class CountSquares {

    private val points = HashMap<Int, HashMap<Int, Int>>()

    fun add(point: IntArray) {
        val x = point[0]
        val y = point[1]

        points.putIfAbsent(x, HashMap())
        val yMap = points[x]!!
        yMap[y] = yMap.getOrDefault(y, 0) + 1
    }

    fun count(point: IntArray): Int {
        val x = point[0]
        val y = point[1]

        if (!points.containsKey(x)) return 0

        var result = 0
        val yMap = points[x]!!

        for ((ny, freq) in yMap) {

            if (ny == y) continue

            val side = ny - y

            // Right square
            result += freq *
                    (points[x + side]?.get(y) ?: 0) *
                    (points[x + side]?.get(ny) ?: 0)

            // Left square
            result += freq *
                    (points[x - side]?.get(y) ?: 0) *
                    (points[x - side]?.get(ny) ?: 0)
        }

        return result
    }
}