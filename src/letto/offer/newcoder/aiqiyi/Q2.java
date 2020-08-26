package letto.offer.newcoder.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int res = cal(arr);
        System.out.println(res);
    }

    private static int cal(int[] arr) {
        int res = 0;
        while(arr[arr.length-1]>0){
            if(arr[0] == 0){
                res+=arr[arr.length-1];
                break;
            }
            for(int i = 1; i<arr.length; i++){
                arr[i]--;
            }
            Arrays.sort(arr);
            res++;

        }

        return res;
    }
}
