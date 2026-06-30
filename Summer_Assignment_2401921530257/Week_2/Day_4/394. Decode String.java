import java.util.*;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(num);
                stringStack.push(curr);
                num = 0;
                curr = new StringBuilder();
            } else if (ch == ']') {
                int k = countStack.pop();
                StringBuilder temp = stringStack.pop();
                for (int i = 0; i < k; i++) {
                    temp.append(curr);
                }
                curr = temp;
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}
