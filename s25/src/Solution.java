/* https://leetcode-cn.com/problems/teemo-attacking/ */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int end = 0;
        int cnt = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            cnt += duration;
            if (i > 0) {
                if (timeSeries[i] <= end) { // 存在交集
                    cnt -= end - timeSeries[i] + 1;
                }
            }
            end = timeSeries[i] + duration - 1;
        }

        return cnt;
    }
}
