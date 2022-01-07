/* https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/ */
public class Solution {
    public int maxDepth(String s) {
        int cur = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cur++;
                max = Math.max(cur, max);
            } else if (c == ')') {
                cur--;
            }
        }
        return max;
    }
}
