/* https://leetcode-cn.com/problems/heaters/ */
import java.util.Arrays;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int answer = 0;
        for (int house : houses) {
            answer = Math.max(Math.abs(house - heaters[binarySearch(heaters, house)]), answer);
        }
        return answer;
    }

    int binarySearch(int[] heaters, int target) {
        int left = 0, right = heaters.length - 1;
        int ret = -1;
        int delta = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (right - left + 1) / 2 + left;
            int heater = heaters[mid];
            int d = Math.abs(heater - target);
            if (d < delta) {
                delta = d;
                ret = mid;
            }
            if (heater > target) right = mid - 1;
            else left = mid + 1;
        }
        return ret;
    }
}
