package letto.offer.dp;

/**
 * 众所周知，牛能和牛可乐经常收到小粉丝们送来的礼物，每个礼物有特定的价值，他俩想要尽可能按照自己所得价值来平均分配所有礼物。
 *
 * 那么问题来了，在最优的情况下，他俩手中得到的礼物价值和的最小差值是多少呢？
 * p.s 礼物都很珍贵，所以不可以拆开算哦
 *输入
 * [1,2,3,4]
 *
 * 0
 */

public class Q1_maxPresent {
    public int maxPresent (int[] presentVec) {
        int len = presentVec.length;
        int sum = 0;
        for (int present:presentVec){
            sum += present;
        }
        int capacity = sum >> 1;
        //用来存储能到达的价值总数
        boolean[] dp = new boolean[capacity+1];
        dp[0] = true;
        for (int i = 0; i<presentVec.length; i++){
            int present = presentVec[i];
            for (int j = capacity; j>=present; j--){
                if (dp[j-present] == true){
                    dp[j] = true;
                }
            }
        }

        int one = capacity;
        while(dp[one] ==false) one--;
        int res = sum - 2*one;
        return res;

    }


}
