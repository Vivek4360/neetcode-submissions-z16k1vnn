class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        
        // Store the last occurrence index of each character
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        
        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // Update the end to the furthest last occurrence of current characters
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            
            // If we've reached the end of the current partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}