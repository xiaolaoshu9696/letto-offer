package letto.offer.leetcode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class leetcode76 {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        leetcode76 s = new leetcode76();
        System.out.println(s.minWindow(S,T));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            int count = need.getOrDefault(t.charAt(i), 0);
            need.put(t.charAt(i), count+1);
        }
        String res = "";

        int left = 0, right = -1;
        int start = 0, end = s.length()-1;
        int len = Integer.MAX_VALUE;
        while(right<s.length()-1){
            //扩大窗口
            right++;
            char cur = s.charAt(right);
            if(need.containsKey(cur)){
                window.put(cur, window.getOrDefault(cur, 0)+1);
            }
            //满足条件，收缩left
            while(check(need,window)&&left<=right){
                if(right-left+1<len){
                    start = left;
                    end = right;
                    len = right-left+1;
                }
                if(window.containsKey(s.charAt(left))){
                    window.put(s.charAt(left), window.get(s.charAt(left))-1);
                }
                left++;
            }

        }
        return len==Integer.MAX_VALUE ? "":s.substring(start,end+1);

    }

    public boolean check(Map<Character, Integer> need, Map<Character,Integer> window){
        for(Map.Entry<Character, Integer> entry: need.entrySet()){
            //遍历每一个需要的字母
            char key = entry.getKey();
            if(window.getOrDefault(key,0)<entry.getValue()) return false;
        }
        return true;

    }

}
