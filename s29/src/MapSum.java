import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapSum {
    private Map<String, Integer> map = new HashMap<>();
    private Trie dict = new Trie('.');

    public void insert(String key, int val) {
        this.map.put(key, val);
        this.dict.addWord(key);
    }

    public int sum(String prefix) {
        int cnt = 0;
        for (String key : dict.findPrefix(prefix)) {
            cnt += map.get(key);
        }
        return cnt;
    }


    static class Trie {
        char c;
        String word;
        Map<Character, Trie> children = new HashMap<>();

        public Trie(char c) {
            this.c = c;
        }

        public void addWord(String word) {
            Trie self = this;
            for (char ch : word.toCharArray()) {
                if (self.children.containsKey(ch)) {
                    self = self.children.get(ch);
                } else {
                    Trie child = new Trie(ch);
                    self.children.put(ch, child);
                    self = child;
                }
            }
            self.word = word;
        }

        public List<String> getWords() {
            List<String> ret = new ArrayList<>();
            if (this.word != null) ret.add(this.word);
            for (Trie child : this.children.values()) ret.addAll(child.getWords());

            return ret;
        }

        public List<String> findPrefix(String prefix) {
            Trie self = this;
            for (int i = 0; i < prefix.length() && self != null; i++) {
                self = self.children.get(prefix.charAt(i));
            }
            return self == null ? new ArrayList<>() : self.getWords();
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */