/* https://leetcode-cn.com/problems/maximum-product-of-word-lengths/solution/zui-da-dan-ci-chang-du-cheng-ji-by-leetc-lym9/ */
import java.util.Arrays;

public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] w = new int[n];
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                w[i] |= 1 << c - 'a';
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            String word1 = words[i];
            if (word1.length() * word1.length() < max) break;
            for (int j = i + 1; j < n; j++) {
                String word2 = words[j];
                int len = word1.length() * word2.length();
                if (len < max) break;
                if ((w[i] & w[j]) == 0) max = len;
            }
        }

        return max;
    }

}
