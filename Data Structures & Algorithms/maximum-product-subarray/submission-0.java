class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            
            
            int tempMax = maxSoFar;
            
            
            maxSoFar = Math.max(current, Math.max(maxSoFar * current, minSoFar * current));
            minSoFar = Math.min(current, Math.min(tempMax * current, minSoFar * current));
            
            
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }
}