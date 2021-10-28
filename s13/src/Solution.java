import java.util.*;

public class Solution {
    // 更好的方法可以打表， 因为2的整数次幂密度小！！

    public boolean reorderedPowerOf2(int n) {
        return dfs(n + "", "");
    }

    public boolean dfs(String rest, String cur) {
        if (rest.length() == 0) {
            return isValid(Integer.parseInt(cur));
        }
        for (int i = 0; i < rest.length(); i++) {
            char c = rest.charAt(i);
            if (cur.length() == 0 && c == '0') continue;

            if (dfs(rest.substring(0, i) + rest.substring(i + 1), cur + c)) return true;
        }

        return false;
    }

    public boolean isValid(int n) {
        return ((n - 1) & n) == 0;
    }
}
