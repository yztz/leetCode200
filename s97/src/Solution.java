/* https://leetcode-cn.com/problems/jump-game-iv/ */
import java.util.*;

public class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> idxSameValue = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            idxSameValue.putIfAbsent(arr[i], new ArrayList<Integer>());
            idxSameValue.get(arr[i]).add(i);
        }
        Set<Integer> visitedIndex = new HashSet<Integer>();
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0, 0});
        visitedIndex.add(0);
        while (!queue.isEmpty()) {
            int[] idxStep = queue.poll();
            int idx = idxStep[0], step = idxStep[1];
            if (idx == arr.length - 1) {
                return step;
            }
            int v = arr[idx];
            step++;
            if (idxSameValue.containsKey(v)) {
                for (int i : idxSameValue.get(v)) {
                    if (visitedIndex.add(i)) {
                        queue.offer(new int[]{i, step});
                    }
                }
                idxSameValue.remove(v);
            }
            if (idx + 1 < arr.length && visitedIndex.add(idx + 1)) {
                queue.offer(new int[]{idx + 1, step});
            }
            if (idx - 1 >= 0 && visitedIndex.add(idx - 1)) {
                queue.offer(new int[]{idx - 1, step});
            }
        }
        return -1;
    }
}

// 使用迪杰斯特拉会超出内存占用，所以只能使用BFS

//public class Solution {
//    public int minJumps(int[] arr) {
//        final int INFINITE = 1000000000;
//        int n = arr.length;
//        int[][] dist = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == j) dist[i][i] = 0;
//                else dist[i][j] = INFINITE;
//            }
//        }
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            int num = arr[i];
//            List<Integer> eqi = map.getOrDefault(num, new ArrayList<>());
//            for (int idx : eqi) {
//                dist[idx][i] = 1;
//                dist[i][idx] = 1;
//            }
//            eqi.add(i);
//            map.put(arr[i], eqi);
//            if (i > 0) {
//                dist[i][i - 1] = 1;
//                dist[i - 1][i] = 1;
//            }
//        }
//        Set<Integer> D = new HashSet<>();
//        int[] d = dist[0];
//        D.add(0);
//        while (D.size() < n) {
//            int min = INFINITE;
//            int node = 0;
//            for (int i = 0; i < n; i++) {
//                if (D.contains(i)) continue;
//                if (d[i] < min) {
//                    min = d[i];
//                    node = i;
//                }
//            }
//            D.add(node);
//            for (int i = 0; i < n; i++) {
//                d[i] = Math.min(d[i], d[node] + dist[node][i]);
//            }
//        }
//
//        return d[n - 1];
//    }
//}
