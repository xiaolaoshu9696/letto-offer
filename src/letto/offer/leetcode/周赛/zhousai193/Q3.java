package letto.offer.leetcode.周赛.zhousai193;

import java.util.Arrays;

/*

给你一个整数数组 bloomDay，以及两个整数 m 和 k 。

现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。

花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。

请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
输出：3
解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
现在需要制作 3 束花，每束只需要 1 朵。
1 天后：[x, _, _, _, _]   // 只能制作 1 束花
2 天后：[x, _, _, _, x]   // 只能制作 2 束花
3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3

输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
输出：9
 */
public class Q3 {

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length<m*k) return -1;
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int min = 0;
        //要取到左边界
        while(min < max){
            int mid = min+ (max-min)/2;
            //等待mid天，有多少组连续的k朵花已经开了。
            int count = getCount(bloomDay,mid, k);
            if (count>=m){
                max = mid;
            }else {
                min = mid+1;
            }
        }
        return min;
    }

    private static int getCount(int[] bloomDay, int day, int k) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i]<=day){
                count++;
            }else {
                count=0;
            }
            if (count==k){
                res++;
                count=0;
            }
        }
        return res;
    }
}
