/* https://leetcode-cn.com/problems/nth-digit/solution/ */
public class Solution {
    /*
        0-9     10 * 1

        10-99   90 * 2
        100-999 900 * 3
        1000-9999 9000 * 4
     */
    public int findNthDigit(int n) {
        if (n < 10) return n;

        n -= 10;
        long a = 90;
        int len = 2;
        while (n - a * len >= 0) {
            n -= a * len;
            len++;
            a *= 10;
        }

        int nth = n / len;
        int idx = n % len;

        String t = nth + a / 9 + "";
        return t.charAt(idx) - '0';

    }
}
