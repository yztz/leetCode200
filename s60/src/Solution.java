/* https://leetcode-cn.com/problems/loud-and-rich/ */
import java.util.*;
public class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<>();
        }
        int[] inDeg = new int[n];
        for (int[] r : richer) {
            g[r[0]].add(r[1]);
            ++inDeg[r[1]];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = i;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : g[x]) {
                if (quiet[ans[x]] < quiet[ans[y]]) {
                    ans[y] = ans[x]; // 更新 x 的邻居的答案
                }
                if (--inDeg[y] == 0) {
                    q.offer(y);
                }
            }
        }
        return ans;
    }
}
