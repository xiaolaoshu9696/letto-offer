package letto.offer.newcoder.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int k = sc.nextInt();
        long res = cal(x,y,z,k);
        System.out.println(res);

    }

    public static long cal(int x, int y, int z, int k){
        int[] len = new int[]{x,y,z};
        Arrays.sort(len);
        int[] time = new int[3];
        if(x+y+z-3<=k) return (long)x*y*z;

        while(k>0){
            //切x
            if (len[0]>1){
                time[0]++;
                len[0]--;
                k--;
            }
            if (k==0)break;
            if (len[1]>1){
                time[1]++;
                len[1]--;
                k--;
            }
            if (k==0)break;
            if (len[2]>1){
                time[2]++;
                len[2]--;
                k--;
            }
        }
        return (long)(time[0]+1)*(time[1]+1)*(time[2]+1);

    }
}
