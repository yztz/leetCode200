/* https://leetcode-cn.com/problems/shuffle-an-array/ */
import java.util.Random;

public class Solution {
    int[] copy;
    int[] nums;
    Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
    }

    public int[] reset() {
        return copy;
    }

    public int[] shuffle() {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = Math.abs(random.nextInt()) % len;
            int k = Math.abs(random.nextInt()) % len;
            swap(j, k);
        }

        return nums;
    }

    private void swap(int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
