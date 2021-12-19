import java.util.Arrays;

public class Solution {
    public int findJudge(int n, int[][] trusts) {
        int[] believers = new int[n + 1];

        for (int[] trust : trusts) {
            int a = trust[0];
            int b = trust[1];
            believers[a]--;
            believers[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (believers[i] == n - 1) return i;
        }

        return -1;
    }
}
