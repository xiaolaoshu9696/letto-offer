package letto.offer.pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Q5_2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int left = 1;
        int right = n*m;
        k = n*m-k+1;  //倒序。
        while (left<right){
            int mid = (left+right)/2;
            int cnt = 0;
            for (int i = 1;i<=n;i++){
                cnt +=Math.min(m,mid/i);
            }
            if (cnt>=k) right = mid;
            else left = mid+1;

        }
        System.out.println(right);




//        int index = 0;
//        int[] arr = new int[n*m];
//        for (int i = 1; i<=n; i++){
//            for (int j = 1; j<=m; j++){
//                arr[index] = i*j;
//                index++;
//            }
//        }
//        Arrays.sort(arr);
//        System.out.println(arr[n*m-k]);

    }

}
