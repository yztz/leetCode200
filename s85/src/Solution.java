public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char answer = keysPressed.charAt(0);
        int time = releaseTimes[0];
        for (int i = 1; i < keysPressed.length(); i++) {
            char c = keysPressed.charAt(i);
            int delta = releaseTimes[i] - releaseTimes[i - 1];

            if (delta > time) {
                answer = c;
                time = delta;
            } else if (delta == time && c > answer) {
                answer = c;
            }
        }

        return answer;
    }
}
