/* https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/ */

import java.util.*;

public class Solution {


    public List<Integer> findAnagrams(String s, String p) {
        int[] origin = new int[26];
        int[] current = new int[26];

        List<Integer> answers = new ArrayList<>();

        for (char c : p.toCharArray()) {
            origin[c - 'a']++;
            current[c - 'a']++;
        }

        int len = p.length();
        int flag = len;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
//            System.out.println(Arrays.toString(current));
            int c = s.charAt(i) - 'a';
            if (origin[c] != 0) {
                if (current[c] > 0) {
                    current[c]--;
                    flag--;
                    if (flag == 0) {    // add answer move next
                        answers.add(begin);
                        current[s.charAt(begin) - 'a']++;
                        begin++;
                        flag++;
                    }
                } else {    // rest == 0 move next
                    int bc;
                    while ((bc = s.charAt(begin) - 'a') != c) {
                        current[bc]++;
                        begin++;
                        flag++;
                    }
                    begin++;
                }
            } else {
                System.arraycopy(origin, 0, current, 0, 26);
                begin = i + 1;
                flag = len;
            }
        }
        return answers;
    }


}
