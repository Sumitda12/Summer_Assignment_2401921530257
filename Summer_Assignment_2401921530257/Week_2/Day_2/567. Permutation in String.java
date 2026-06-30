class Solution {
    private boolean checkEqual(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
        }
        int i = 0;
        int windowSize = s1.length();
        int[] count2 = new int[26];
        while (i < windowSize) {
            count2[s2.charAt(i) - 'a']++;
            i++;
        }
        if (checkEqual(count1, count2)) {
            return true;
        }
        while (i < s2.length()) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - windowSize) - 'a']--;
            i++;
            if (checkEqual(count1, count2)) {
                return true;
            }
        }
        return false;
    }
}
