import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* https://leetcode-cn.com/problems/zuma-game/ */
public class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().del("AABBBAAC"));
        System.out.println(new Solution().findMinStep("RRWWRRBBRR"
                ,"WB"));
    }

    Map<String, Map<String, Integer>> states = new HashMap<>();

    public int findMinStep(String board, String hand) {
        char[] hands = hand.toCharArray();
        Arrays.sort(hands);
        return putBall(board, String.copyValueOf(hands));
    }


    public int putBall(String board, String hand) {
        if (board.length() == 0) {
            return 0;
        }

        if (hand.length() == 0) {
            return -1;
        }

        if (states.containsKey(board)) {
            Map<String, Integer> map = states.get(board);
            if (map.containsKey(hand)) return map.get(hand);
        }

//        System.out.println("board: " + board);
//        System.out.println("hand: " + hand);
        int minStep = Integer.MAX_VALUE;
        int len = board.length();
        boolean flag = false;
        char prev_ball = hand.charAt(0);
        for (int j = 0; j < hand.length(); j++) {
            char ball = hand.charAt(j);
            if (j > 0 && ball == prev_ball) {
                continue;
            } else {
                prev_ball = ball;
            }
            for (int i = 0; i < board.length(); i++) {
                char c = board.charAt(i);
                String newBoard = del(board.substring(0, i) + ball + board.substring(i));
                String newHand = hand.substring(0, j) + hand.substring(j + 1);
                if (c == ball && i < len - 1 && c == board.charAt(i + 1)) i += 1;
                int step = putBall(newBoard, newHand);
                if (step == 0) return 1;
                else if (step > 0) {
                    minStep = Math.min(minStep, step);
                    flag = true;
                }
            }
        }

        int res = flag ? minStep + 1 : -1;
        Map<String, Integer> map = states.getOrDefault(board, new HashMap<>());
        map.put(hand, res);
        states.put(board, map);

        return res;
    }


    public String del(String board) {

        StringBuilder sb = new StringBuilder(board);
        do {
            board = sb.toString();
            sb.setLength(0);
            int idx = 0;
            for (int i = 0; i < board.length(); i++) {
                if (board.charAt(i) != board.charAt(idx)) {
                    int len = i - idx;
                    if (len < 3) {
                        char c = board.charAt(idx);
                        for (int j = 0; j < len; j++) sb.append(c);
                    }
                    idx = i;
                }
            }

            int len = board.length() - idx;
            if (len < 3) {
                char c = board.charAt(idx);
                for (int j = 0; j < len; j++) sb.append(c);
            }
        } while (sb.length() != 0 && sb.length() != board.length());

        return sb.toString();
    }
}
