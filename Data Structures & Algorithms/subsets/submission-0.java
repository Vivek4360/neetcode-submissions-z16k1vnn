class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Step 1: Add current subset to result
        result.add(new ArrayList<>(current));

        // Step 2: Try all possibilities
        for (int i = start; i < nums.length; i++) {
            // Choose element
            current.add(nums[i]);

            // Explore further
            backtrack(i + 1, nums, current, result);

            // Backtrack (undo choice)
            current.remove(current.size() - 1);
        }
    }
}