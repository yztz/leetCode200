/* https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/ */
public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] max = new int[m + n];
        for (int i = 0; i < m; i++) {
            int hmax = 0;
            for (int j = 0; j < n; j++) {
                hmax = Math.max(hmax, grid[i][j]);
            }
            max[i] = hmax;
        }
        for (int i = 0; i < n; i++) {
            int hmax = 0;
            for (int[] ints : grid) {
                hmax = Math.max(hmax, ints[i]);
            }
            max[m + i] = hmax;
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = grid[i][j];
                answer += Math.min(max[i] - h, max[m + j] - h);
            }
        }
        return answer;
    }

}
