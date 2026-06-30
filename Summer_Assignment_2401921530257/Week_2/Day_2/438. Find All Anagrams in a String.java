import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : p.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int k = p.length();
        int count = freq.size();
        while (right < s.length()) {
            char current = s.charAt(right);
            if (freq.containsKey(current)) {
                freq.put(current, freq.get(current) - 1);
                if (freq.get(current) == 0) {
                    count--;
                }
            }
            if (right - left + 1 < k) {
                right++;
            } else if (right - left + 1 == k) {
                if (count == 0) {
                    ans.add(left);
                }
                char outgoing = s.charAt(left);
                if (freq.containsKey(outgoing)) {
                    if (freq.get(outgoing) == 0) {
                        count++;
                    }
                    freq.put(outgoing, freq.get(outgoing) + 1);
                }
                left++;
                right++;
            }
        }
        return ans;
    }
}
