import java.math.BigDecimal;
import java.util.Arrays;

public class Solution {
    // 不可行， 100位长的数字大小为 2 ^ 100 * 5 ^ 100 >> long 2 ^ 64 ???
    // 但是可以采用BigDecimal ???

//    public int[] plusOne(int[] digits) {
//        StringBuilder sb = new StringBuilder();
//        for (int digit : digits) sb.append(digit);
//        int a = Integer.parseInt(sb.toString());
//        a++;
//    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean carry = false;
        int cur = len - 1;
        while (carry && cur >= 0 || cur == len - 1) {
            digits[cur] = (digits[cur] + 1) % 10;
            carry = digits[cur] == 0;
            cur--;
        }
        if (carry) {
            int[] ret = new int[len + 1];
            ret[0] = 1;
            System.arraycopy(digits, 0, ret, 1, len);
            return ret;
        }

        return digits;
    }
}
