package letto.offer;

import java.util.*;


public class Main {


    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int len = num.length;
        if(num==null || len<3) return res;
        Arrays.sort(num);
        for(int i = 0; i<len; i++){
            if(num[i]>0) break;
            if(i>0 && num[i]==num[i-1]) continue;
            int L = i+1;
            int R = len-1;
            while(L<R){
                int sum = num[i]+num[L]+num[R];
                if(sum==0){
                    ArrayList<Integer> p = new ArrayList<>();
                    p.add(num[i]);
                    p.add(num[L]);
                    p.add(num[R]);
                    res.add(p);
                    while(L<R && num[L]==num[L+1]) L++;
                    while (L<R && num[R] == num[R-1]) R--; // 去重
                    L++;
                    R--;

                }
                else if(sum<0) L++;
                else if(sum>0) R--;
            }

        }

        return res;
    }

}