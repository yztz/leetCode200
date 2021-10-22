import java.util.ArrayList;
import java.util.List;

/* https://leetcode-cn.com/problems/majority-element-ii/ */
public class Solution {


    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int standard = n / 3;
        int vote1 = 0;
        int vote2 = 0;

        int e1 = 0;
        int e2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && num == e1) {
                vote1++;
            } else if (vote2 > 0 && num == e2) {
                vote2++;
            } else if (vote1 == 0) {
                vote1++;
                e1 = num;
            } else if (vote2 == 0) {
                vote2++;
                e2 = num;
            } else {
                vote1--;
                vote2--;
            }
        }
        // 下面这部分其实还可以优化
        List<Integer> answers = new ArrayList<>();
        int count;
        if (vote1 > 0) {
            count = 0;
            for (int num : nums) if (num == e1) count++;
            if (count > standard) answers.add(e1);
        }

        if (vote2 > 0) {
            count = 0;
            for (int num : nums) if (num == e2) count++;
            if (count > standard) answers.add(e2);
        }

        return answers;
    }
}
