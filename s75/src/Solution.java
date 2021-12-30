/* https://leetcode-cn.com/problems/hand-of-straights/ */
import java.util.*;

//public class Solution {
//    public boolean isNStraightHand(int[] hand, int groupSize) {
//        if (hand.length % groupSize != 0) return false;
//        PriorityQueue<Integer> p = new PriorityQueue<>();
//        for (int h : hand) {
//            p.offer(h);
//        }
//        int pre = p.poll();
//        int count = 1;
//        while (!p.isEmpty()) {
////            System.out.println(p.size());
//            System.out.println(pre);
//            System.out.println(p);
//            List<Integer> list = new ArrayList<>();
//            if (count % groupSize > 0) {    // 还没凑成组
//                int t = pre;
//                while (!p.isEmpty() && (t = p.poll()) <= pre) list.add(t);
//                if (t != pre + 1) {
//                    return false;
//                } else {
//                    pre++;
//                }
//                p.addAll(list);
//            } else {
//                pre = p.poll();
//            }
//            count++;
//        }
//        return true;
//    }
//}

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : hand) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!cnt.containsKey(x)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = x + j;
                if (!cnt.containsKey(num)) {
                    return false;
                }
                cnt.put(num, cnt.get(num) - 1);
                if (cnt.get(num) == 0) {
                    cnt.remove(num);
                }
            }
        }
        return true;
    }
}
