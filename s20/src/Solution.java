import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 0;
        for (int value : arr) {
            dp.put(value, dp.getOrDefault(value - difference, 0) + 1);
            answer = Math.max(answer, dp.get(value));
        }
        return answer;
    }
}
