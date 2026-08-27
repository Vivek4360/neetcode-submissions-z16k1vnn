public class Solution {
    public boolean divideArray(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);

        int i = 0;
        while (i < N) {
            int j = i;
            while (j < N && nums[i] == nums[j]) {
                j++;
            }

            if ((j - i) % 2 != 0) {
                return false;
            }

            i = j;
        }

        return true;
    }
}