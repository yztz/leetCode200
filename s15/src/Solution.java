import java.util.*;

/* https://leetcode-cn.com/problems/keyboard-row/ */
public class Solution {

    static String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static Map<Character, Integer> wordMap = new HashMap<>();

    static {
        for (int i = 0; i < 3; i++) {
            String line = lines[i];
            for (char c : line.toCharArray()) {
                wordMap.put(c, i);
                wordMap.put(Character.toUpperCase(c), i);
            }
        }
    }

    public String[] findWords(String[] words) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            int line = wordMap.get(word.charAt(0));
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (wordMap.get(c) != line){
                    flag = false;
                    break;
                }
            }
            if (flag) answer.add(word);
        }
        return answer.toArray(new String[0]);
    }
}
