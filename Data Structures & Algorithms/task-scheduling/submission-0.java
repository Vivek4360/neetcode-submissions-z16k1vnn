class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char t : tasks) {
            freq[t - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];

        int countMaxFreq = 1;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == maxFreq) countMaxFreq++;
            else break;
        }

        int result = (maxFreq - 1) * (n + 1) + countMaxFreq;

        return Math.max(tasks.length, result);
    }
}