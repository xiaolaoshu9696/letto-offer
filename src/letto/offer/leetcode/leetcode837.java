package letto.offer.leetcode;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

public class leetcode837 {

    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0;
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K-1] = 1.0*Math.min(N-K+1,W)/W;
        for (int i = K-2; i >=0 ; i--) {
            dp[i] = dp[i+1]- (dp[i+W+1]-dp[i+1])/W;
        }


//        for (int i = K - 1; i >= 0; i--) {
//            for (int j = 1; j <= W; j++) {
//                dp[i] += dp[i + j] / W;
//            }
//            if (dp[K - 1] == 1.0) {
//                return 1.0;
//            }
//        }

        return dp[0];


    }

}
