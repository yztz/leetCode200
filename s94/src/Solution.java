/* https://leetcode-cn.com/problems/minimum-time-difference/ */
import java.util.Collections;
import java.util.List;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0;
        Collections.sort(timePoints);
        int zt = getMinutes(timePoints.get(0));
        int pt = zt;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - pt);
            pt = minutes;
        }
        ans = Math.min(ans, 1440 - pt + zt);
        return ans;
    }

    public int getMinutes(String str) {
        return 60 * ((str.charAt(0) - '0') * 10 + (str.charAt(1) - '0')) + (str.charAt(3) - '0') * 10 + (str.charAt(4) - '0');
    }
}
