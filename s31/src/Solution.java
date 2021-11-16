import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isRectangleCover(int[][] rectangles) {

        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();
        int area = 0;
        for (int[] rectangle : rectangles) {
            int x = rectangle[0];
            int y = rectangle[1];
            int a = rectangle[2];
            int b = rectangle[3];

            x1 = Math.min(x1, x);
            y1 = Math.min(y1, y);
            x2 = Math.max(x2, a);
            y2 = Math.max(y2, b);

            add(x, y, set);
            add(a, b, set);
            add(x, b, set);
            add(y, a, set);

            area += (a - x) * (b - y);
        }

        if ((x2 - x1) * (y2 - y1) != area) return false;

        return set.size() == 4 &&
                set.contains(key(x1, y1)) &&
                set.contains(key(x2, y2)) &&
                set.contains(key(x1,y2)) &&
                set.contains(key(x2, y1));
    }

    public void add(int x, int y, Set<Integer> set) {
        int key = key(x, y);
        if (set.contains(key)) {
            set.remove(key);
        } else {
            set.add(key);
        }
    }


    public int key(int x, int y) {
        return x * 100007 + y;
    }
}
