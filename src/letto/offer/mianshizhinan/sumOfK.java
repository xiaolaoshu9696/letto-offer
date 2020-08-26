package letto.offer.mianshizhinan;

import java.util.Scanner;

public class sumOfK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        printSumOfK(k, arr);
    }

    public static void printSumOfK(int k, int[] arr){


        int i= 0;
        int j = arr.length-1;
        while (i<j){
            int sum = arr[i] + arr[j];
            if (sum<k) i++;
            else if (sum>k) j--;
            else {

                System.out.println(arr[i]+ " " +arr[j]);
                while (arr[i]==arr[i+1]) i++;
                while (arr[j]==arr[j-1]) j--;
                i++;
                j--;
            }

        }


    }



}
