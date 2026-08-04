class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var n = n
        val f = IntArray(flowerbed.size + 2)
        for (i in flowerbed.indices) {
            f[i + 1] = flowerbed[i]
        }

        for (i in 1 until f.size - 1) {
            if (f[i - 1] == 0 && f[i] == 0 && f[i + 1] == 0) {
                f[i] = 1
                n--
            }
        }

        return n <= 0
    }
}