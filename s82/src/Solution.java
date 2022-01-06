import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        String[] patterns = path.split("/");
        for (String pattern : patterns) {
            if (pattern.length() == 0) continue;
            switch (pattern) {
                case ".":
                    break;
                case "..":
                    deque.poll();
                    break;
                default:
                    deque.push(pattern);
                    break;
            }
        }
        if (deque.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) sb.append("/").append(deque.pollLast());
        return sb.toString();
    }
}
