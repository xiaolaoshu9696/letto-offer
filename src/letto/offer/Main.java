package letto.offer;


import java.util.*;

public class Main {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int len = words.length;
        for(int i = 0; i<len-1; i++){
            for(int j = i+1; j<len; j++){
                if(ishuiwen(words[i],words[j])){
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                    List<Integer> list2 = new ArrayList();
                    list.add(j);
                    list.add(i);
                    res.add(list2);

                }
            }
        }

        return res;

    }

    public boolean ishuiwen(String s1, String s2){
        String s = s1+s2;
        int l = s.length();
        for(int i = 0; i<l/2; i++){
            if(s.charAt(i)!=s.charAt(l-1-i)) return false;
        }
        return true;
    }
}
