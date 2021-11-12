/* https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/ */
public class Solution {

    public int getMoneyAmount(int n) {
        int cnt = 0;
        int[][] cost = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int max = k + Math.max(cost[i][k - 1], cost[k + 1][j]);
                    min = Math.min(min, max);
                }
                cost[i][j] = min;
            }
        }

        return cost[1][n];
    }

}
