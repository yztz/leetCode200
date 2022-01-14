/* https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/ */
import java.util.*;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        List<List<Integer>> answers = new ArrayList<>();
        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            List<Integer> answer = new ArrayList<>();
            answer.add(nums1[pair[0]]);
            answer.add(nums2[pair[1]]);
            answers.add(answer);
            if (pair[1] + 1 < n) {
                pq.offer(new int[]{pair[0], pair[1] + 1});
            }
            k--;
        }

        return answers;
    }
}
