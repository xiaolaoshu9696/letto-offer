package letto.offer.mianshizhinan.dp;

import java.util.Scanner;

public class longyudixiacheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = mat[n - 1][m - 1] >= 0 ? 1 : (1 - mat[n - 1][m - 1]);
        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = (dp[i + 1][m - 1] - mat[i][m - 1]) > 0 ? (dp[i + 1][m - 1] - mat[i][m - 1]) : 1;
        }
        for (int j = m - 2; j >= 0; j--) {
            dp[n - 1][j] = (dp[n - 1][j + 1] - mat[n - 1][j]) > 0 ? (dp[n - 1][j + 1] - mat[n - 1][j]) : 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = (Math.min(dp[i + 1][j], dp[i][j + 1]) - mat[i][j]) > 0 ? (Math.min(dp[i + 1][j], dp[i][j + 1]) - mat[i][j]) : 1;
            }
        }
        System.out.println(dp[0][0]);

    }


}
