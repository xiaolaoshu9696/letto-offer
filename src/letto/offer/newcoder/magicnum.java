package letto.offer.newcoder;

/**
 * 链接：https://ac.nowcoder.com/acm/problem/202589
 * 来源：牛客网
 *
 *         一天，牛妹找牛牛做一个游戏，牛妹给牛牛写了一个数字n，然后又给自己写了一个数字m，她希望牛牛能执行最少的操作将他的数字转化成自己的。
 * 操作共有三种，如下：
 *         1.在当前数字的基础上加一，如：4转化为5
 *         2.在当前数字的基础上减一，如：4转化为3
 *         3.将当前数字变成它的平方，如：4转化为16
 *         你能帮牛牛解决这个问题吗?
 */

public class magicnum {
    public static void main(String[] args) {
        magicnum s = new magicnum();
        System.out.println(s.solve(2,50));
    }

    public int solve (int n, int m) {
        // write code here
        if(n>m) return n-m;
        int[] dp = new int[m+1];
        for(int i = n; i>0; i--){
            dp[i] = n-i;
        }
        for(int i = n+1; i<m+1;i++){
            dp[i] = findshortpath(dp, i);
        }
        return dp[m];


    }

    public int findshortpath(int[] dp, int now){
        int sq = (int)Math.sqrt(now);
        int low = sq*sq;
        int high = (sq+1)*(sq+1);
        if (low==now) return Math.min(dp[sq]+1,dp[now-1]+1);
        int l1 = now-low + dp[sq]+1;
        int l2 = high-now + dp[sq+1]+1;
        if (l1<l2) return Math.min(l1,dp[now-1]+1);
        return Math.min(l2,dp[now-1]+1);
    }
}
