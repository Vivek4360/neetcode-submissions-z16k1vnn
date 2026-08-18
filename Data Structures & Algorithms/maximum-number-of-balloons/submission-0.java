class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        // Count characters
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        // Calculate how many balloons each character can make
        int b = count['b' - 'a'];
        int a = count['a' - 'a'];
        int l = count['l' - 'a'] / 2;
        int o = count['o' - 'a'] / 2;
        int n = count['n' - 'a'];

        return Math.min(
            Math.min(b, a),
            Math.min(Math.min(l, o), n)
        );
    }
}
