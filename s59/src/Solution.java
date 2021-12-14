/* https://leetcode-cn.com/problems/course-schedule-iii/solution/ */
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int total = 0;
        for (int[] course : courses) {
            int ti = course[0];
            int di = course[1];
            if (total + ti <= di) {
                total += ti;
                queue.offer(ti);
            } else if (!queue.isEmpty() && queue.peek() > ti) { // peek > ti: 不存在比当前ti更长的课程了
                total -= queue.poll() - ti;
                queue.offer(ti);
            }
        }
        return queue.size();
    }
}
