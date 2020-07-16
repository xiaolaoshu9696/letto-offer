package letto.offer.leetcode;

public class leetcode174 {

    public static void main(String[] args) {
        leetcode174 s = new leetcode174();
        int[][] dungeon = new int[][]{{-3,5}};
        System.out.println(s.calculateMinimumHP(dungeon));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        dp[row-1][col-1] = dungeon[row-1][col-1]>0? 1: 1-dungeon[row-1][col-1];
        for(int i=row-2; i>=0; i--){
            dp[i][col-1] = (dp[i+1][col-1]-dungeon[i][col-1]) > 0 ? (dp[i+1][col-1]-dungeon[i][col-1]) : 1;
        }
        for(int i=col-2; i>=0; i--){
            dp[row-1][i] = (dp[row-1][i+1]-dungeon[row-1][i]) > 0 ? (dp[row-1][i+1]-dungeon[row-1][i]) : 1;
        }

        for(int i = row-2; i>=0; i--){
            for(int j = col-2; j>=0; j--){
                if(dp[i+1][j] - dungeon[i][j] <=0 || dp[i][j+1]-dungeon[i][j]<=0){
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = Math.min(dp[i+1][j] - dungeon[i][j], dp[i][j+1]-dungeon[i][j]);

            }
        }

        return dp[0][0];
    }
}
