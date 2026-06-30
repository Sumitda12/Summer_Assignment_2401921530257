class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) {
                continue;
            }
            String pattern = s.substring(0, len);
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < n / len; i++) {
                temp.append(pattern);
            }
            if (temp.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
