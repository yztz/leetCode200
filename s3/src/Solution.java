/* https://leetcode-cn.com/problems/number-complement/ */
public class Solution {

    public int findComplement(int num) {
        int c = 0;
        while (num > 0) {
            num <<= 1;
            c += 1;
        }
        return ~num >> c;
    }
}
