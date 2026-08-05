class Solution {
    fun majorityElement(nums: IntArray): Int {

        val n = nums.size
        for(num in nums){
            var count = 0
            for(i in nums){
                if(i == num){
                    count++

                }
            }

            if(count > n /2 ){
                return num
            }
        }

        return -1



    }
}
