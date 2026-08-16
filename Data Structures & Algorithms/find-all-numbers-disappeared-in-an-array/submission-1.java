public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] mark = new boolean[n];

        for (int num : nums) {
            mark[num - 1] = true;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!mark[i - 1]) {
                res.add(i);
            }
        }
        return res;
    }
}