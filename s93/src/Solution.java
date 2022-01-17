/* https://leetcode-cn.com/problems/count-vowels-permutation/ */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countVowelPermutation(int n) {
        long mod = 1000000007;
        long[] dp = new long[5];
        long[] ndp = new long[5];
        for (int i = 0; i < 5; ++i) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            /* a前面可以为e,u,i */
            ndp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            /* e前面可以为a,i */
            ndp[1] = (dp[0] + dp[2]) % mod;
            /* i前面可以为e,o */
            ndp[2] = (dp[1] + dp[3]) % mod;
            /* o前面可以为i */
            ndp[3] = dp[2];
            /* u前面可以为i,o */
            ndp[4] = (dp[2] + dp[3]) % mod;
            System.arraycopy(ndp, 0, dp, 0, 5);
        }
        long ans = 0;
        for (int i = 0; i < 5; ++i) {
            ans = (ans + dp[i]) % mod;
        }
        return (int)ans;
    }
}



//public class Solution {
//    static final int MOD = 1000000000 + 7;
//    static int[][] next = {
//            {1},
//            {0, 2},
//            {0, 1, 3, 4},
//            {2, 4},
//            {0},
//    };
//    Map<Integer, Integer>[] maps;
//    public int countVowelPermutation(int n) {
//        if (n == 1) return 5;
//        maps = new Map[5];
//        for (int i = 0; i < 5; i++) maps[i] = new HashMap<>();
//        int ans = 0;
//        for (int i = 0; i < 5; i++) {
//            ans += dfs(i, n);
//            ans %= MOD;
//        }
//        return ans;
//    }
//
//    private int dfs(int ch, int n) {
//        if (n == 1) return 1;
//        if (maps[ch].containsKey(n)) return maps[ch].get(n);
//        int ans = 0;
//        for (int next : next[ch]) {
//            ans += dfs(next, n - 1);
//            ans %= MOD;
//        }
//        maps[ch].put(n, ans);
//        return ans;
//    }
//}


