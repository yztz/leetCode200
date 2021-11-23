/* https://leetcode-cn.com/problems/buddy-strings/solution/qin-mi-zi-fu-chuan-by-leetcode-solution-yyis/ */
public class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int count = 0;
        char[][] ch = new char[2][2];
        int[] set = new int[26];
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = goal.charAt(i);

            if (!flag) {
                int idx = ch1 - 'a';
                set[idx]++;
                if (set[idx] > 1) flag = true;
            }

            if (ch1 != ch2) {
                if (count == 2) return false;
                ch[count][0] = ch1;
                ch[count][1] = ch2;
                count++;
            }

        }

        return count == 0 && flag || count == 2 && ch[0][0] == ch[1][1] && ch[0][1] == ch[1][0];
    }
}
