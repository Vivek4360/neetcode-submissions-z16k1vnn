public class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        for (int i = 0; i < n; i++) {
            boolean match = true;
            int idx = 0;
            for (int j = n - i; j < n && match; j++) {
                if (nums[idx] != sortedNums[j]) {
                    match = false;
                }
                idx += 1;
            }

            for (int j = 0; j < n - i && match; j++) {
                if (nums[idx] != sortedNums[j]) {
                    match = false;
                }
                idx += 1;
            }

            if (match) return true;
        }

        return false;
    }
}