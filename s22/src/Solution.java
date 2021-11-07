/* https://leetcode-cn.com/problems/range-addition-ii/ */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int width = n;
        int height = m;
        for (int[] op : ops) {
            int a = op[0];
            int b = op[1];

            if (a < height) {
                height = a;
            }

            if (b < width) {
                width = b;
            }
        }

        return width * height;
    }
}
