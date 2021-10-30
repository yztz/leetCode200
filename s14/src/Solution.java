/* https://leetcode-cn.com/problems/single-number-iii/ */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) x ^= nums[i];

        int l = x & -x;

        int x1 = 0, x2 = 0;

        for (int num : nums) {
            if ((num & l) == 0) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }


        return new int[]{x1, x2};
    }
}
