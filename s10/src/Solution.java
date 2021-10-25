/* https://leetcode-cn.com/problems/search-a-2d-matrix-ii/submissions/ */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = n - 1;

        while (j >= 0 && i < m) {
            int cur = matrix[i][j];
            if (cur == target) return true;

            if (target > cur) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
