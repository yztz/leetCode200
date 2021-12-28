/* https://leetcode-cn.com/problems/concatenated-words/ */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        List<String> answers = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            if (judge(word, 0, root, false)) answers.add(word);
            else root.add(word);
        }
        return answers;
    }

    boolean judge(String s, int i, Trie t, boolean flag) {
        Trie tmp = t;
        int len = s.length();
        if (flag && i == len) return true;
        for (; i < (flag ? len : len - 1); i++) {
            char c = s.charAt(i);
            if (tmp.children[c - 'a'] != null) {
                tmp = tmp.children[c - 'a'];
                if (tmp.is) {
                    if (judge(s, i + 1, t, true)) return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    static class Trie {
        Trie[] children = new Trie[26];
        boolean is = false;

        Trie _add(char c) {
            int idx = c - 'a';
            if (children[idx] != null) return children[idx];
            Trie ret = new Trie();
            this.children[c - 'a'] = ret;
            return ret;
        }

        void add(String s) {
            Trie t = this;
            for (char c : s.toCharArray()) t = t._add(c);
            t.is = true;
        }
    }
}
