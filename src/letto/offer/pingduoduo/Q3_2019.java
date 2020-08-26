package letto.offer.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Q3_2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int min= Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<n/2; i++){
            int sum =arr[i] + arr[n-1-i];
            if (sum>max) max = sum;
            if (sum<min) min = sum;
        }
        System.out.println(max-min);

    }
}
