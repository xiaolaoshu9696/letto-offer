package letto.offer.leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class leetcode139 {
    public static void main(String[] args) {
        String s = "catsandog";
        String[] a ={"cats","dog","sand","and","cat"};
        List<String> slist = Arrays.asList(a);
        System.out.println(wordBreak(s,slist));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i<s.length();i++){
            if (wordDict.contains(s.substring(0,i+1))) dp[i] = true;
            for (int j =0; j<i; j++){
                if (dp[j]){
                    if (wordDict.contains(s.substring(j+1,i+1))) dp[i] = true;
                }
            }
        }

        return dp[s.length()-1];

    }


}
