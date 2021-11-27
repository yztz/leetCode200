/* https://leetcode-cn.com/problems/random-flip-matrix/ */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    private int m;
    private int n;
    private final Gap ORIGIN_GAP;


    Random random = new Random();
    List<Gap> gaps = new ArrayList<>();

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.ORIGIN_GAP = new Gap(0, m * n);
        this.gaps.add(ORIGIN_GAP);
    }

    public int[] flip() {
        int gapIdx = Math.abs(random.nextInt()) % gaps.size();
        Gap gap = gaps.remove(gapIdx);
        System.out.println(gap);
        int loc;
        if (gap.length == 1) {
            loc = gap.begin;
        } else {
            int locIdx = Math.abs(random.nextInt()) % gap.length;
            loc = gap.begin + locIdx;
            Gap l = createGap(gap.begin, loc);
            Gap r = createGap(loc + 1, gap.end);
            if (l != null) gaps.add(l);
            if (r != null) gaps.add(r);
        }
        System.out.println(loc);
        return new int[]{loc / n, loc % n};
    }

    private Gap createGap(int begin, int end) {
        if (end <= begin) return null;

        return new Gap(begin, end);
    }

    public void reset() {
        this.gaps.clear();
        this.gaps.add(ORIGIN_GAP);
    }


}

class Gap {
    int begin;
    int end;
    int length;
    Gap(int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.length = end - begin;
    }

    @Override
    public String toString() {
        return "Gap{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}