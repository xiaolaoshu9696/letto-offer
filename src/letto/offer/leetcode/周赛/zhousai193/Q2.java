package letto.offer.leetcode.周赛.zhousai193;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q2 {
    public static void main(String[] args) {
        int[] a = {4,3,1,1,3,3,2};
        System.out.println(findLeastNumOfUniqueInts(a,3));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int a: arr){
            int times=  map.getOrDefault(a, 0);
            times++;
            map.put(a,times);
        }
        ArrayList<Integer> A = new ArrayList<Integer>(map.values());
        int[] time = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            time[i] = A.get(i);
        }
        Arrays.sort(time);
        int index = 0;
        for (int i = 0; i < A.size(); i++) {
            k = k-time[i];
            index++;
            if (k<=0) break;
        }
        if (k<0) return A.size()-index+1;
        else return A.size()-index;
    }
}
