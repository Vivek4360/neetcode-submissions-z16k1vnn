class Solution:
    def myPow(self, x: float, n: int) -> float:
        exp = n
        ans = 1.0

        if exp < 0:
            x = 1 / x
            exp = -exp

        while exp > 0:
            if exp % 2 == 1:
                ans *= x
            x *= x
            exp //= 2

        return ans