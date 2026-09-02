class Solution {
    fun getConcatenation(nums: IntArray): IntArray {

        val n = nums.size

        val ans = IntArray( 2 * n)

        for(i in 0 until n){

        ans[i] = nums[i]
        ans[i + n] = nums[i]

    }
    
    return ans

    }
}
