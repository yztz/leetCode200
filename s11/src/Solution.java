import java.util.*;

/* https://leetcode-cn.com/problems/next-greater-element-i/ */
public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> bigger = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            int num = nums2[i];
            if (!deque.isEmpty()) {
                if (num < deque.peek()) {
                    bigger.put(num, deque.peek());
                } else {
                    do { deque.pop(); } while (!deque.isEmpty() && deque.peek() <= num);
                    if (deque.isEmpty()) {
                        bigger.put(num, -1);
                    } else {
                        bigger.put(num, deque.peek());
                    }
                }
            } else {
                bigger.put(num, -1);
            }
            deque.push(num);
        }
        int[] answers = new int[n];

        for (int i = 0; i < n; i++) {
            answers[i] = bigger.get(nums1[i]);
        }

        return answers;
    }
}
