class Solution {
    fun maxArea(heights: IntArray): Int {

        var left = 0
        var right = heights.size - 1   
        var max = 0

        while (left < right) {

            val width = right - left
            val h = minOf(heights[left], heights[right])   
            val area = width * h

            max = maxOf(max, area)

            if (heights[left] < heights[right]) {   
                left++
            } else {
                right--
            }
        }

        return max
    }
}
