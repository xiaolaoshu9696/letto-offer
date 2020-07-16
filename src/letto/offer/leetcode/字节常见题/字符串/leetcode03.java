package letto.offer.leetcode.字节常见题.字符串;

import java.util.HashSet;

public class leetcode03 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    //滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int n = s.length();
        int right = 0;
        for(int i = 0; i<n; i++){
            if(i!=0) set.remove(s.charAt(i-1));

            while(right<n && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            res = Math.max(res, right-i);
            if(right==n) break;

        }
        return res;
    }
}
