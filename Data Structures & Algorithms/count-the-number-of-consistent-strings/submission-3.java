public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;

        for (String w : words) {
            boolean flag = true;
            for (char c : w.toCharArray()) {
                if (allowed.indexOf(c) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) res++;
        }

        return res;
    }
}