class NumArray(private val nums: IntArray) {

    fun sumRange(left: Int, right: Int): Int {
        var res = 0
        for (i in left..right) {
            res += nums[i]
        }
        return res
    }
}