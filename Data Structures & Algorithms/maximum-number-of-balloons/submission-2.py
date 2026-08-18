class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        count = [0] * 26

        # Count characters
        for c in text:
            count[ord(c) - ord('a')] += 1

        b = count[ord('b') - ord('a')]
        a = count[ord('a') - ord('a')]
        l = count[ord('l') - ord('a')] // 2
        o = count[ord('o') - ord('a')] // 2
        n = count[ord('n') - ord('a')]

        return min(b, a, l, o, n)
