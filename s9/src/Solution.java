import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* https://leetcode-cn.com/problems/shopping-offers/ */
public class Solution {
    List<List<Integer>> special;
    List<Integer> price;
    Map<List<Integer>, Integer> needs;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        this.price = price;
        this.needs = new HashMap<>();

        this.special = new ArrayList<>();
        for (List<Integer> pkg : special) {
            boolean flag = true;
            int curPrice = 0;
            for (int i = 0; i < n; i++) {
                int num = pkg.get(i);
                if (num > needs.get(i)) {
                    flag = false;
                    break;
                }
                curPrice += num * price.get(i);
            }
            if (flag && curPrice > pkg.get(n)) this.special.add(pkg);
        }
        System.out.println(this.special);

        return dfs(needs);
    }


    public int dfs(List<Integer> need) {
        if (!needs.containsKey(need)) {
            int n = need.size();
            int curPrice = 0;
            for (int i = 0; i < n; i++) curPrice += need.get(i) * price.get(i);
            for (List<Integer> pkg : special) {
                boolean flag = true;
                List<Integer> nextNeed = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int pkgNum = pkg.get(i);
                    int curNum = need.get(i);
                    if (pkgNum > curNum) {
                        flag = false;
                        break;
                    }
                    nextNeed.add(curNum - pkgNum);
                }
                if (flag) {
                    curPrice = Math.min(curPrice, pkg.get(n) + dfs(nextNeed));
                }
            }
            needs.put(need, curPrice);
        }
        return needs.get(need);
    }


}
