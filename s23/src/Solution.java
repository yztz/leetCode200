/* https://leetcode-cn.com/problems/bulls-and-cows/ */

public class Solution {
    public String getHint(String secret, String guess) {
        int[] cnt = new int[10];

        int bull = 0;
        int cow = 0;

        for (int i = 0; i < guess.length(); i++) {
            int sc = secret.charAt(i) - '0';
            int gc = guess.charAt(i) - '0';
            if (gc == sc) {
                bull++;
            } else {
                cnt[sc]++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            int sc = secret.charAt(i) - '0';
            int gc = guess.charAt(i) - '0';
            if (gc != sc && cnt[gc] > 0) {
                cow++;
                cnt[gc]--;
            }
        }

        return String.format("%dA%dB", bull, cow);
    }
}
