/* https://leetcode-cn.com/problems/coloring-a-border/ */
public class Solution {
    int[][] grid;
    int color;
    Boolean[][] flag = new Boolean[50][50];
    int m, n;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int c = grid[row][col];
        if (c == color) return grid;
        this.grid = grid;
        this.color = color;
        this.m = grid.length;
        this.n = grid[0].length;
        System.out.println(flag[0][0]);
        dfs(row, col, c);
        return grid;
    }

    public boolean dfs(int row, int col, int preColor) {
        if (row < 0 || col < 0 || row == m || col == n) return true;
        if (flag[row][col] != null) return flag[row][col];
        int c = grid[row][col];
        if (preColor != c) {
            flag[row][col] = true;
            return true;
        } else {
            flag[row][col] = false;
        }

        boolean f = dfs(row - 1, col, c);
        f |= dfs(row + 1, col, c);
        f |= dfs(row, col - 1, c);
        f |= dfs(row, col + 1, c);
        System.out.println(f);
        if (f) grid[row][col] = color;

        return false;
    }
}
