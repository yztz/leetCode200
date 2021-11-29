/* https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/solution/ */
public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0.0, right = 1.0;
        int n = arr.length;

        while (true) {
            double mid = (left + right) / 2;
            int count = 0;
            int max1 = 0, max2 = 1;
            int i = -1;
            for (int j = 1; j < n; j++) {
                while ((double) arr[i + 1] / arr[j] < mid) {
                    i++;
                    if (arr[i] * max2 > arr[j] * max1) {
                        max1 = arr[i];
                        max2 = arr[j];
                    }
                }
                count += i + 1;
            }
            if (count == k) {
                return new int[]{max1, max2};
            } else if (count > k) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }
}
