package letto.offer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

public class Q27_Permutation {
    //全排列问题，递归回溯
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str!=null && str.length()>0){
            backtrack(str.toCharArray(),0,res);
        }
        return res;
    }

    public void backtrack(char[] cs, int i, ArrayList<String> list){
        if (i == cs.length-1){
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else{
            for (int j = i; j<cs.length; j++){
                swap(cs,i,j);
                backtrack(cs, i+1, list);
                //回溯
                swap(cs,i,j);
            }
        }
    }
    public void swap(char[] cs, int i, int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}

