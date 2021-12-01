public class Solution {
    public int maxPower(String s) {
        int max = 1;
        int count = 1;
        char pre = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pre) count++;
            else {
                max = Math.max(max, count);
                count = 0;
                pre = c;
            }
        }

        max = Math.max(max, count);

        return max;
    }
}
