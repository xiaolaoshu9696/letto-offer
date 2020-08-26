package letto.offer.字节跳动;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q2_手串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();


        for (int i = 0; i<n; i++){
            int num_c = sc.nextInt();
            if (num_c==0) continue;
            for (int j = 0; j<num_c; j++){
                int cur_c = sc.nextInt();
                ArrayList<Integer> list  = map.getOrDefault(cur_c,new ArrayList<Integer>());
                list.add(i);
                map.put(cur_c, list);
            }
        }
        int res = 0;
        for (ArrayList<Integer> arr : map.values()){
            boolean f = ishefa(arr,m,n);
            if(!f){
                res++;
            }
        }

        System.out.println(res);

    }
    public static boolean ishefa(ArrayList<Integer> arr, int m, int n){
        boolean flag = true;
        int len = arr.size();
        if (len==1) return flag;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i]= arr.get(i);
        }
        for (int i = 0; i<len; i++){
            if (a[i]+m-1<n){
                if (a[i]+m-1>=a[i+1]){
                    flag = false;
                    break;
                }
            }
            else{
                int index = a[i]+m-1-n;
                if (index>=a[0]){
                    flag = false;
                    break;
                }
            }
        }
        return flag;

    }

}
