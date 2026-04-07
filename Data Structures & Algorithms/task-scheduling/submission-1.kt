class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26)

        // Count frequency of each task
        for (t in tasks) {
            freq[t - 'A']++
        }

        // Sort the frequency array
        freq.sort()

        // Get max frequency
        val maxFreq = freq[25]

        // Count how many tasks have max frequency
        var countMaxFreq = 1
        for (i in 24 downTo 0) {
            if (freq[i] == maxFreq) {
                countMaxFreq++
            } else {
                break
            }
        }

        // Apply formula
        val result = (maxFreq - 1) * (n + 1) + countMaxFreq

        // Return max of tasks size or computed result
        return maxOf(tasks.size, result)
    }
}