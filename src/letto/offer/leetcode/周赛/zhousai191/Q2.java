package letto.offer.leetcode.周赛.zhousai191;

import java.util.Arrays;

public class Q2 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int xlen = horizontalCuts.length;
        int ylen = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long[] x = new long[xlen + 1];
        long[] y = new long[ylen + 1];
        for (int i = 0; i < xlen + 1; i++) {
            if (i == 0) x[i] = horizontalCuts[0];
            else if (i == xlen) x[i] = h - horizontalCuts[xlen - 1];
            else x[i] = horizontalCuts[i] - horizontalCuts[i - 1];
        }
        for (int j = 0; j < ylen + 1; j++) {
            if (j == 0) y[j] = verticalCuts[0];
            else if (j == ylen) y[j] = w - verticalCuts[ylen - 1];
            else y[j] = verticalCuts[j] - verticalCuts[j - 1];
        }

        long max_x = maxValue(x);
        long max_y = maxValue(y);

        long res = ((max_x%1000000007)*(max_y%1000000007))%1000000007;
        return (int) res;
    }

    private static long maxValue(long[] arr){
        long max = Long.MIN_VALUE;
        for (long a:arr) {
            max = Math.max(a, max);
        }
        return max;
    }
}
