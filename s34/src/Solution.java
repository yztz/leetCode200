import java.util.HashMap;
import java.util.Map;

/* https://leetcode-cn.com/problems/integer-replacement/ */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().integerReplacement(2147483647));
    }
    public int integerReplacement(int n) {
        return backtrace(n);
    }

    Map<Long, Integer> map = new HashMap<>();

    public int backtrace(long n) {
//        System.out.println(n);
        if (map.containsKey(n)) return map.get(n);

        int answer = 0;
        long origin = n;
        if ((n & (n - 1)) == 0) {
            while (n != 1) {
                answer++;
                n >>= 1;
            }
        } else {
            if (n % 2 == 0) {
                answer = 1 + backtrace(n / 2);
            } else {
                answer = 1 + Math.min(backtrace(n + 1), backtrace(n - 1));
            }
        }

        map.put(origin, answer);
        return answer;
    }

}
