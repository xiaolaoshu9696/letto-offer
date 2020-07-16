package letto.offer.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = findmax(candies);
        for (int i = 0; i < candies.length; i++) {
            if (candies[i]>=max-extraCandies) res.add(true);
            else res.add(false);
        }
        return res;
    }
    public static int findmax(int[] candies){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i],max);
        }
        return max;
    }


}
