package letto.offer.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class leetcode784 {
    public static void main(String[] args) {
        leetcode784 s = new leetcode784();
        System.out.println(s.letterCasePermutation("a1b2"));
    }
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        char[] c = S.toCharArray();
        backtrack(c, 0);
        return res;
    }

    public void backtrack(char[] c, int cur){
        res.add(String.valueOf(c));
        for(int i = cur; i<c.length; i++){
            int nowchar = c[i];
            if(nowchar>='a' && nowchar<='z'){
                c[i] -=32;
                backtrack(c,i+1);
                c[i]+=32;
            }else if(nowchar>='A' && nowchar<='Z'){
                c[i] += 32;
                backtrack(c,i+1);
                c[i]-=32;
            }
        }
    }
}
