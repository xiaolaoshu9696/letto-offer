package letto.offer.leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class leetcode621 {
    public static void main(String[] args) {

    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int size = map.size();
        Integer[] times = new Integer[size];
        int index = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            times[index++] = entry.getValue();
        }
        Arrays.sort(times, (o1,o2)-> o2-o1);
        int res = 0;
        while(times[0]>0){
            int i = 0;
            while(i<=n){
                if(times[0]==0) break;
                if(i<times.length && times[i]>0){
                    times[i]--;
                }
                res++;
                i++;
            }
            Arrays.sort(times, (o1, o2)->(o2-o1));
        }

        return res;

    }
}
