package letto.offer.leetcode.dp;

public class mianshi46 {
    int res;
    //动态规划
    public int translateNum(int num) {
        String s_num = String.valueOf(num);
        int[] dp = new int[s_num.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1;i<s_num.length();i++){
            if (Integer.parseInt(s_num.substring(i-1,i+1))<=25){
                dp[i+1] = dp[i] + dp[i-1];
            }
            else dp[i+1] = dp[i];
        }
        return dp[s_num.length()];
    }

    //递归dfs
    public int translateNum2(int num) {
        int res = 0;
        String str = String.valueOf(num);
        dfs(str,0);
        return res;
    }

    private void dfs(String str, int n) {
        if (n>=str.length()-1){
            res++;
            return;
        }
        dfs(str,n+1);
        if (str.charAt(n)-'0'>0 && n+1<str.length() && (str.charAt(n) - '0') * 10 + str.charAt(n + 1) - '0' < 26 ){
            dfs(str,n+2);
        }
    }


}
