class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalGas = 0
        var totalCost = 0
        var currentTank = 0
        var startStation = 0
        
        for (i in gas.indices) {
            totalGas += gas[i]
            totalCost += cost[i]
            currentTank += gas[i] - cost[i]
            
            // If current tank becomes negative, reset starting station
            if (currentTank < 0) {
                startStation = i + 1
                currentTank = 0
            }
        }
        
        // If total gas is less than total cost, no solution exists
        return if (totalGas < totalCost) -1 else startStation
    }
}