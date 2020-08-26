package letto.offer.mianshizhinan;

import java.util.Map;
import java.util.Scanner;

public class maxsubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.next().toCharArray();
        char[] str2 = sc.next().toCharArray();
        int[][] dp = getdp(str1,str2);
        int m = str1.length-1;
        int n = str2.length-1;
        char[] res = new char[dp[m][n]];
        int index = res.length-1;
        while (index>=0){
            if (n>0 && dp[m][n]==dp[m][n-1]) n--;
            else if (m>0 && dp[m][n]==dp[m-1][n]) m--;
            else {
                res[index--] = str1[m];
                m--;
                n--;
            }

        }
        System.out.println(String.valueOf(res));

    }

    public static int[][] getdp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ?1:0;
        for (int i=1; i< str1.length; i++){
            dp[i][0] = Math.max(dp[i-1][0],str1[1] == str2[0] ?1:0);
        }
        for (int j=1; j<str2.length; j++){
            dp[0][j] = Math.max(dp[0][j-1],str1[0] == str2[j] ?1:0);
        }
        for (int i = 1; i<str1.length; i++){
            for (int j = 1; j<str2.length; j++){
                dp[i][j] =Math.max(dp[i-1][j], dp[i][j-1]);
                if (str1[i] == str2[j]){
                    dp[i][j]= Math.max(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        return dp;
    }

}