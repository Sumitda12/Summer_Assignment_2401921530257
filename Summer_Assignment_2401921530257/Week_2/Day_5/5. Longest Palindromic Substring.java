class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        int start = 0;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            int left = i - 1;
            int right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
            left = i - 1;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
                left--;
                right++;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
