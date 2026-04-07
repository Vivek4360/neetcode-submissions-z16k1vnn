class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val target = nums.size - k
        return quickSelect(nums, 0, nums.lastIndex, target)
    }

    private fun quickSelect(nums: IntArray, left: Int, right: Int, k: Int): Int {
        if (left == right) return nums[left]

        val pivotIndex = partition(nums, left, right)

        return when {
            k == pivotIndex -> nums[k]
            k < pivotIndex -> quickSelect(nums, left, pivotIndex - 1, k)
            else -> quickSelect(nums, pivotIndex + 1, right, k)
        }
    }

    private fun partition(nums: IntArray, left: Int, right: Int): Int {
        val pivot = nums[right]
        var i = left

        for (j in left until right) {
            if (nums[j] <= pivot) {
                nums.swap(i, j)
                i++
            }
        }

        nums.swap(i, right)
        return i
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}