class Solution {
    public int lengthOfLongestSubstring(String s) {

          int n = s.length();
        int maxLen = 0;
        int start = 0; 
        HashSet<Character> set = new HashSet<>();

        for (int end = 0; end < n; end++) {
            char current = s.charAt(end); 
            
            
            while (set.contains(current)) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(current); 
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
