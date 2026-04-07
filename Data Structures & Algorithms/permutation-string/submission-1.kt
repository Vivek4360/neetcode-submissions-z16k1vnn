class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
       if (s1.length > s2.length) return false

        val s1Count = IntArray(26)
        val windowCount = IntArray(26)

        
        for (i in s1.indices) {
            s1Count[s1[i] - 'a']++
            windowCount[s2[i] - 'a']++
        }

        
        if (s1Count.contentEquals(windowCount)) return true

        for (i in s1.length until s2.length) {

            
            windowCount[s2[i] - 'a']++

            
            windowCount[s2[i - s1.length] - 'a']--

            if (s1Count.contentEquals(windowCount)) return true
        }

        return false


    }
}
