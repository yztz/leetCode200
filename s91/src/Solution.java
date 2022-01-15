/* https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/ */
public class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
        int count = 0;
        for (int i = 1; i <= weeks; i++) {
            count += 7 * (i + 3);
        }
        for (int i = 0; i < days; i++) {
            count += weeks + 1 + i;
        }

        return count;
    }
}
