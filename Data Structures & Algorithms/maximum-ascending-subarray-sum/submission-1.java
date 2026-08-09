public class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int curSum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[j - 1]) {
                    break;
                }
                curSum += nums[j];
            }
            res = Math.max(res, curSum);
        }
        return res;
    }
}