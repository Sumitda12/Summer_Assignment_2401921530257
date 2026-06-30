import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (char ch : ransomNote.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) - 1);
            if (freq.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
