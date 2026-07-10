class Solution {

    fun isHappy(n: Int): Boolean {

        val set = HashSet<Int>()
        var num = n

        while (num != 1) {

            if (set.contains(num)) {
                return false
            }

            set.add(num)
            num = squareSum(num)
        }

        return true
    }

    fun squareSum(n: Int): Int {

        var num = n
        var sum = 0

        while (num > 0) {

            val digit = num % 10
            sum += digit * digit
            num /= 10
        }

        return sum
    }
}