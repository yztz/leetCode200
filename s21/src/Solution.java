/* https://leetcode-cn.com/problems/missing-number/ */
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int num : nums) cnt += num;
        return n*(n + 1)/2 - cnt;
    }
}
