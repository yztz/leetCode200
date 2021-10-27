import java.util.*;
/* https://leetcode-cn.com/problems/remove-invalid-parentheses/submissions/ */
public class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> answer = new ArrayList<>();
        Set<String> cur = new HashSet<>();

        cur.add(s);
        while (true) {
            for (String str : cur) {
                if (isValid(str)) answer.add(str);
            }
            /*
                为什么是正确的？
                因为要求是最少删除，而最少删除的括号是固定的，所以正确答案在bfs中能一次得出
             */
            if (answer.size() > 0) return answer;

            Set<String> next = new HashSet<>();
            for (String str : cur) {
                for (int i = 0; i < str.length(); i++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) continue;  // or  i - 1 and i but i != n - 1!
                    char c = str.charAt(i);
                    if (c == '(' || c == ')') {
                        next.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            cur = next;
        }
    }

    public boolean isValid(String str) {
        int lCnt = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') lCnt++;
            else if (c == ')') {
                if (lCnt > 0) lCnt--;
                else return false;
            }
        }

        return lCnt == 0;
    }
}
