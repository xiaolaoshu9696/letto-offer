package letto.offer.leetcode;
//最长回文子串


import javax.sound.midi.Track;

public class leetcode05 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abaaba"));
    }

    public static String longestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l=0; l<n; l++){
            for (int i = 0; i<n;i++){
                int j = i+l;
                if (j>=n) break;
                if (l==0) dp[i][j]= true;
                else if (l==1) dp[i][j] = s.charAt(i)==s.charAt(j);
                else dp[i][j] = (dp[i+1][j-1] && s.charAt(i)==s.charAt(j));
                if (dp[i][j] && l+1>ans.length()) ans = s.substring(i,j+1);

            }
        }
        return ans;


    }
}
