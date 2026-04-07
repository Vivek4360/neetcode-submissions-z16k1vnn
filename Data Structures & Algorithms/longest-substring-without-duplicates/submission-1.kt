class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        var maxLen = 0

        var start = 0

        val set = mutableSetOf<Char>()


        for(end in s.indices){

            val current = s[end]


            while(set.contains(current)){
                set.remove(s[start])

                start++;
            }
            set.add(current)

            maxLen = maxOf(maxLen, end - start + 1)
        }

        return maxLen

    }
}
