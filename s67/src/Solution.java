public class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int answer = 1;
        while (2 * b.length() >= sb.length()) {
            if (sb.indexOf(b) != -1) return answer;
            sb.append(a);
            answer++;
        }
        return -1;
    }
}
