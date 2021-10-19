import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionary {
    char c;
    String s;
    Map<Character, WordDictionary> children;

    public WordDictionary() {
        this.children = new HashMap<>();
    }

    public WordDictionary(char c) {
        this();
        this.c = c;
    }

    public void addWord(String word) {
        WordDictionary cur = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            cur.children.putIfAbsent(ch, new WordDictionary(ch));
            cur = cur.children.get(ch);
        }
        cur.s = word;
    }

    public boolean search(String word) {
        WordDictionary cur = this;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                if (i + 1 == len) {
                    for (WordDictionary child : cur.children.values())
                        if (child.s != null) return true;

                    return false;
                }
                String ss = word.substring(i + 1, len);
                for (WordDictionary child : cur.children.values())
                    if (child.search(ss)) return true;

                return false;
            } else {
                if (!cur.children.containsKey(ch)) return false;
                cur = cur.children.get(ch);
            }
        }

        return cur.s != null;
    }
}
