package letto.offer.leetcode.回溯;
import java.util.*;

public class leetcode17 {
    Map<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        leetcode17 s = new leetcode17();
        System.out.println(s.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghl");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        char[] ca = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(ca, sb, 0);
        return res;
    }

    public void dfs(char[] ca, StringBuilder temp, int cur){
        if(temp.length()==ca.length){
            res.add(temp.toString());
            return;
        }
        String nowstring = map.get(ca[cur]);
        for(int i = 0; i<nowstring.length(); i++){
            temp.append(nowstring.charAt(i));
            dfs(ca, temp, cur+1);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}
