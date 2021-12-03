/* https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/solution/ */
import java.util.Arrays;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int minus = 0;
        int answer = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                minus++;
            } else break;
        }
        if (minus >= k) {
            for (i = 0; i < nums.length; i++, k--) {
                if (k > 0) {
                    answer += -nums[i];
                } else {
                    answer += nums[i];
                }
            }
            return answer;
        } else {
            int rest = k - minus;
            if (rest % 2 == 0) {
                for (i = 0; i < nums.length; i++) answer += Math.abs(nums[i]);
                return answer;
            } else {
                System.out.println(answer);
                int min = Integer.MAX_VALUE;
                for (i = 0; i < nums.length; i++) {
                    int tmp = Math.abs(nums[i]);
                    answer += tmp;
                    min = Math.min(tmp, min);
                    System.out.println(answer);
                }
                return answer - 2 * min;
            }
        }


    }
}
