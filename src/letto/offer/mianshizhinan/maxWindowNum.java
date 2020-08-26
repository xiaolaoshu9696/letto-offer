package letto.offer.mianshizhinan;

import java.util.Arrays;
import java.util.Scanner;

public class maxWindowNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = new int[n-w+1];
        result = windowsNum(arr,w, n);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i==0) s.append(result[i]+"");
            else  s.append(" "+result[i]);
        }
        System.out.println(s.toString());
    }

    public static int[] windowsNum(int[] arr, int w, int n){
        int[] result = new int[n-w+1];
        int max = arr[0];
        for (int i=0; i<w; i++){
            max = Math.max(max,arr[i]);
        }
        result[0] = max;
        for (int j=w; j<n; j++){
            if (max!=arr[j-w] && arr[j]<max){
                result[j-w+1] = max;
            }
            else if (arr[j]>max){
                result[j-w+1] = arr[j];
                max = arr[j];
            }
            else {
                max = Integer.MIN_VALUE;
                for (int k= j-w+1; k<=j; k++){
                    max = Math.max(max,arr[k]);
                    result[j-w+1] = max;
                }
            }
        }
        return result;


    }




}
