class Solution {
    private fun helper(s: String, t: String): Boolean {
        val mp = mutableMapOf<Char, Char>()
        for (i in s.indices) {
            if (mp.containsKey(s[i]) && mp[s[i]] != t[i]) {
                return false
            }
            mp[s[i]] = t[i]
        }
        return true
    }

    fun isIsomorphic(s: String, t: String): Boolean {
        return helper(s, t) && helper(t, s)
    }
}