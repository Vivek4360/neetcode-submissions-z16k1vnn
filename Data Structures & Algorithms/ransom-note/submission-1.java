public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> mag = new ArrayList<>();
        for (char c : magazine.toCharArray()) {
            mag.add(c);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!mag.contains(c)) return false;
            mag.remove((Character) c);
        }

        return true;
    }
}