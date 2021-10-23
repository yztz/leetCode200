/* https://leetcode-cn.com/problems/construct-the-rectangle/ */
public class Solution {

    public int[] constructRectangle(int area) {
        int W = (int) Math.sqrt(area);
        while (area % W != 0) W--;
        return new int[]{area / W, W};
    }
//    public int[] constructRectangle(int area) {
//
//        for (int L = (int) Math.sqrt(area); L <= area; L++) {
//            int W = area / L;
//            if (L >= W && L * W == area) return new int[]{L, W};
//        }
//
//        return null;
//    }
}
