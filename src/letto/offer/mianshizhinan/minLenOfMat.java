package letto.offer.mianshizhinan;

import java.util.Map;
import java.util.Scanner;

public class minLenOfMat {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i<n; i++){
            for (int j =0; j<n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(minlen(mat));

    }

    public static int minlen(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i<col; i++){
            if (i==0) dp[0][0] = mat[0][0];
            else dp[0][i] = mat[0][i]+dp[0][i-1];
        }
        for (int j = 1; j< row; j++){
            dp[j][0] = mat[j][0] + dp[j-1][0];
        }

        for (int i = 1; i<row; i++){
            for (int j = 1; j<col; j++){
                int minnum = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = minnum+mat[i][j];
            }
        }
        return dp[row-1][col-1];

    }


}
