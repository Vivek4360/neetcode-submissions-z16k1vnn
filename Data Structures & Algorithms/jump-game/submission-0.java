class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond our maximum reach, we can't proceed
            if (i > maxReach) {
                return false;
            }
            
            // Update the maximum index we can reach
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If we can already reach the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}