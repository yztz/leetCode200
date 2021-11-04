/* https://leetcode-cn.com/problems/valid-perfect-square/solution/ */
public class Solution {
    public boolean isPerfectSquare(int num) {

        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (left + right) / 2;
            long pow = (long) mid * mid;
            if (pow == num) return true;
            if (pow > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
