package letto.offer.dp;

/**
 *
 * 众所周知，牛妹有很多很多粉丝，粉丝送了很多很多礼物给牛妹，牛妹的礼物摆满了地板。
 * 地板是N\times MN×M的格子，每个格子有且只有一个礼物，牛妹已知每个礼物的体积。
 * 地板的坐标是左上角(1,1)  右下角（N, M）。
 * 牛妹只想要从屋子左上角走到右下角，每次走一步，每步只能向下走一步或者向右走一步或者向右下走一步
 * 每次走过一个格子，拿起（并且必须拿上）这个格子上的礼物。
 * 牛妹想知道，她能走到最后拿起的所有礼物体积最小和是多少？
 */
public class Q2_selectPresent {
    public static void main(String[] args) {
        int[][] present = {{1,2,3},{2,3,4}};
        System.out.println(selectPresent(present));
    }

    public static int selectPresent (int[][] presentVolumn) {
        // write code here
        if (presentVolumn.length==0) return 0;
        int n = presentVolumn.length;
        int m = presentVolumn[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i<n+1; i++){
            for (int j =1; j<m+1; j++){
                if (i == 1){
                    dp[i][j] = dp[i][j-1] + presentVolumn[i-1][j-1];
                }
                else if (j == 1){
                    dp[i][j] = dp[i-1][j] + presentVolumn[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+presentVolumn[i-1][j-1],dp[i][j-1]+presentVolumn[i-1][j-1]),
                            dp[i-1][j-1]+presentVolumn[i-1][j-1]);
                }
            }
        }

        return dp[n][m];


    }
}
