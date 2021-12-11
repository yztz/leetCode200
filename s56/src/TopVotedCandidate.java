import java.util.Arrays;
import java.util.PriorityQueue;

/* https://leetcode-cn.com/problems/online-election/ */
public class TopVotedCandidate {
    int[] top;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        int n = times.length;
        int maxNum = 0;
        top = new int[n];
        this.times = times;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            int person = persons[i];
            cnt[person]++;
            if(cnt[person] >= maxNum) {
                maxNum = cnt[person];
                top[i] = person;
            } else if (i > 0){
                top[i] = top[i - 1];
            }
        }
        System.out.println(Arrays.toString(top));
    }

    public int q(int t) {
        int[] times = this.times;
        int n = times.length;
        int left = 0;
        int right = n - 1;

        while (left < right) {
//            int mid = left + (right - left + 1) / 2;
            // +1是为了向右取
            int mid = (left + right + 1) / 2;
            if (times[mid] <= t) left = mid;
            else right = mid - 1;
        }

        return top[left];
    }
}
