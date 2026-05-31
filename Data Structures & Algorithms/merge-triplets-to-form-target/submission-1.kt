class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        var foundX = false
        var foundY = false
        var foundZ = false
        
        for (triplet in triplets) {
            // If any value exceeds target, skip this triplet
            if (triplet[0] > target[0] || 
                triplet[1] > target[1] || 
                triplet[2] > target[2]) {
                continue
            }
            
            // Check if this triplet can help achieve target values
            if (triplet[0] == target[0]) foundX = true
            if (triplet[1] == target[1]) foundY = true
            if (triplet[2] == target[2]) foundZ = true
            
            // Early exit if we found all three values
            if (foundX && foundY && foundZ) return true
        }
        
        return false
    }
}