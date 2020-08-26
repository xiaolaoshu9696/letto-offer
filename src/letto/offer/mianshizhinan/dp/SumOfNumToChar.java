package letto.offer.mianshizhinan.dp;

import java.util.Scanner;

public class SumOfNumToChar {
    public static void main(String[] args) {
        final long  A = 1000000007;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        boolean flag = false;
        for (int i = 1; i<s.length();i++){
            if (s.charAt(i)=='0'){
                if (s.charAt(i-1)<='2'&&s.charAt(i-1)>'0') dp[i+1] = dp[i-1];
                else{
                    flag = true;
                    break;
                }
            }
            else {
                dp[i+1] = dp[i];
                if (s.charAt(i-1)<='2' && s.charAt(i)<='6'){
                    dp[i+1] = (dp[i+1] +dp[i-1]) % A;
                }
            }

        }
        if (flag) System.out.println(0);
        else System.out.println((dp[s.length()]%A));


    }
}
