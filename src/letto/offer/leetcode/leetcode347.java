package letto.offer.leetcode;

import java.util.*;

public class leetcode347 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for(Integer key:map.keySet()){
            if(heap.size()<k){
                heap.offer(key);
            }else{
                int top = map.get(heap.peek());
                int cur = map.get(key);
                if(cur>top){
                    heap.poll();
                    heap.offer(key);
                }
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(!heap.isEmpty()){
            res[index++] = heap.poll();
        }
        return res;

    }
}
