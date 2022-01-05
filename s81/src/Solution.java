/*https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/*/
public class Solution {
    public String modifyString(String s) {
        int len = s.length();
        if (len == 1) {
            if (s.charAt(0) == '?') return "a";
            else return s;
        }
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(0) == '?') {
            sb.setCharAt(0, getNext('?', sb.charAt(1)));
        }
        if (sb.charAt(len - 1) == '?') {
            sb.setCharAt(len - 1, getNext(sb.charAt(len - 2), '?'));
        }
        for (int i = 1; i < len - 1; i++) {
            if (sb.charAt(i) == '?') {
                sb.setCharAt(i, getNext(sb.charAt(i - 1), sb.charAt(i + 1)));
            }
        }
        return sb.toString();
    }

    char getNext(char left, char right) {
        int c = 0;
        int l = left - 97;
        int r = right - 97;
        while (c == l || c == r) c++;
        return (char) (c + 97);
    }
}
