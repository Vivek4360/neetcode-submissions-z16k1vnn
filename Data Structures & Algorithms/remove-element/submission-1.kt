class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val tmp = mutableListOf<Int>()
        for (num in nums) {
            if (num != `val`) {
                tmp.add(num)
            }
        }
        for (i in tmp.indices) {
            nums[i] = tmp[i]
        }
        return tmp.size
    }
}