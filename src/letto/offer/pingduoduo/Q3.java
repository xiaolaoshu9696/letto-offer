package com;

import java.util.Scanner;

/**
 * @author hkc
 * @date 2020/9/1 19:35
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //商品总数
        int N = sc.nextInt();
        //背包大小
        int M = sc.nextInt();
        int[] weight = new int[N];
        int[] val = new int[N];
        for (int i = 0; i<N; i++){
            weight[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }
        
        int maxpro = getMaxPro(M, weight, val);
        System.out.println(maxpro);
        
    }

    private static int getMaxPro(int m, int[] weight, int[] val) {
        int[] dp = new int[m+1];
        for (int i = 0; i<weight.length; i++){
            for (int j = m; j>=weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+val[i]);
                //（负容量，负价值）
                //负容量，正价值
                //正容量，正价值
                //正容量，负价值
            }
        }
        return dp[m];

    }

    private static int getMaxPro2(int m, int[] weight, int[] val) {
        int[] dp = new int[m+1];
        for (int i = 0; i<weight.length; i++){

            int cur_weight = weight[i];
            int cur_val = val[i];
            //负容量，负价值
            if (cur_weight<0 && cur_val<0){
                for (int j = m; j>=0; j--){

                }
            }

            //负容量，正价值
            else if (cur_weight<0 && cur_val>0){
                for (int j = m; j>=0; j--){
                    dp[j] = dp[j]+cur_val;
                }
            }


            //正容量，负价值
            else if (cur_weight>0 && cur_val<0){
                continue;
            }
            //正容量，正价值
            else if (cur_weight>0 && cur_val>0){
                for (int j = m; j>=weight[i]; j--){
                    dp[j] = Math.max(dp[j], dp[j-weight[i]]+cur_val);

                }
            }

        }
        return dp[m];

    }
}
