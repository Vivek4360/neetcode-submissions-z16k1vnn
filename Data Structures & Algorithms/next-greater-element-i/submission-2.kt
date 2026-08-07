class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val n = nums2.size
        val res = IntArray(nums1.size)

        for (i in nums1.indices) {
            var nextGreater = -1
            for (j in n - 1 downTo 0) {
                if (nums2[j] > nums1[i]) {
                    nextGreater = nums2[j]
                } else if (nums2[j] == nums1[i]) {
                    break
                }
            }
            res[i] = nextGreater
        }

        return res
    }
}