package letto.offer.dp;

public class Q3_rucksack {
    /**
     * 0-1背包问题
     * @param v 背包容量
     * @param n 物品种类
     * @param weight 物品重量
     * @param value 物品价值
     * @return
     */
    public static String ZeroOnePack(int v, int n, int[] weight, int[]value){
        int[][] dp = new int[n+1][v+1];
        for (int i = 1; i<n+1; i++){
            //如果第i件物品的重量大于背包容量j,则不装入背包
            //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
            for (int j=1; j<v+1; j++){
                if (weight[i-1]>j) dp[i][j] = dp[i-1] [j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
            }
        }
        int maxValue = dp[n][v];
        //逆推找出装入背包的所有商品编号
        int j = v;
        String numStr = "";
        for (int i = n; i>0;i--){
            if (dp[i][j]>dp[i-1][j]){
                numStr = i + " " + numStr;
                j = j-weight[i-1];
            }
            if (j==0) break;
        }
        return numStr;
    }

    public static int ZeroOnePack2(int V,int N,int[] weight,int[] value){
        int[] dp =  new int[V+1];
        //每件物品
        for (int i = 1; i <N+1; i++){
            //逆序更新，装下这个物品是否提升价值
            for (int j = V; j>=weight[i-1]; j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
    return dp[V];
    }
}
