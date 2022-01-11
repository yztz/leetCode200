/* https://leetcode-cn.com/problems/additive-number/ */
public class Solution {
    public boolean isAdditiveNumber(String num) {

        int a = 0;
        for (int i = 0; i < num.length() - 1; i++) {
            a *= 10;
            a += num.charAt(i) - '0';
            int b = 0;
            for (int j = i + 1; j < num.length(); j++) {
                b *= 10;
                b += num.charAt(j) - '0';
                if (dfs(a, b, num.substring(j + 1))) {
                    System.out.println(a + " " +b + num.substring(j + 1));
                    return true;
                }
                if (num.charAt(i + 1) == '0') break;
            }
            if (num.charAt(0) == '0') break;
        }
        return false;
    }


    public boolean dfs(int pa, int pb, String num) {
        if (num.length() == 0) return false;
        int a = 0;
        int target = pa + pb;
        for (int i = 0; i < num.length(); i++) {
            a *= 10;
            a += num.charAt(i) - '0';
            if (a == target) {
                if (i == num.length() - 1) return true;
                return dfs(pb, target, num.substring(i + 1));
            } else if (a > target) {
                return false;
            }
            if (num.charAt(0) == '0') return false;
        }
        return false;
    }

}
