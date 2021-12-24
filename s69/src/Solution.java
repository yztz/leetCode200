/* https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/ */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int eatenApples(int[] apples, int[] days) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int answer = 0;
        int i;
        for (i = 0; i < apples.length || !queue.isEmpty(); i++) {
            if (i < apples.length) {
                int apple = apples[i];
                int day = days[i];
                if (apple != 0) {
                    map.put(day + i, map.getOrDefault(day + i, 0) + apple);
                    if (!queue.contains(day + i)) queue.offer(day + i);
                }
            }
            int latestDay;
            while (!queue.isEmpty() && (queue.peek() - i <= 0 || 0 == map.getOrDefault(queue.peek(), 0))) queue.poll();
            if (!queue.isEmpty()) {
                latestDay = queue.peek();
                int num = map.get(latestDay);
                map.put(latestDay, num - 1);
                answer++;
            }
        }
        return answer;
    }
}
