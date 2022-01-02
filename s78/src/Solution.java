/* https://leetcode-cn.com/problems/elimination-game/ */
public class Solution {

    public int lastRemaining(int n) {
        int k = 0;
        int cnt = n;
        int step = 1;
        int ret = 1;
        while (cnt > 1) {
            if (k % 2 == 0) {   // left -> right
                ret += step;
            } else {    // right -> left
                ret = (cnt % 2 == 0) ? ret : ret + step;
            }
            k++;
            cnt >>= 1;
            step <<= 1;
        }
        return ret;
    }
}
