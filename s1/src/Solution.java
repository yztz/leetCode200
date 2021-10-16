import java.util.ArrayList;
import java.util.List;

public class Solution {

    String num;
    List<String> ans;
    int target;
    int len;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.len = num.length();
        this.ans = new ArrayList<>();
        this.target = target;
        backTrace(new StringBuilder(), 0, 0, 0);
        return ans;
    }


    private void backTrace(StringBuilder expr, int i, long res, long mul) {
        if (i == len) {
            if (res == target) ans.add(expr.toString());
            return;
        }
        // 用于占位

        int opIdx = expr.length();
        if (i > 0) expr.append(' ');

        long value = 0;
        for (int j = i; j < len && (i == j || num.charAt(i) != '0'); ++j) {
            char c = num.charAt(j);
            value = value * 10 + c - '0';

            expr.append(c);
            if (i == 0) {
                backTrace(expr, j + 1, value, value);
            } else {
                expr.setCharAt(opIdx, '+');
                backTrace(expr, j + 1, res + value, value);
                expr.setCharAt(opIdx, '-');
                backTrace(expr, j + 1, res - value, -value);
                expr.setCharAt(opIdx, '*');
                backTrace(expr, j + 1, res - mul + mul * value, mul * value);
            }
        }
        expr.setLength(opIdx);
    }




}
