/* https://leetcode-cn.com/problems/poor-pigs/ */
public class Solution {
    public int poorPigs(int n, int d, int t) {
        int k = t / d;
        return (int) Math.ceil(Math.log(n) / Math.log(k + 1));
    }
}
