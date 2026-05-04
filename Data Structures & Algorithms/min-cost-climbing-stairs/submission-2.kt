class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {

        val (dp1, dp0) = cost.foldRight(0 to 0) { c, (n1, n2) ->
        (c + minOf(n1, n2)) to n1
    }
    return minOf(dp0, dp1)




    }
}
