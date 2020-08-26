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
            //二分取中间值
            int mid = (left+right)/2;
            // 矩阵中有cnt个元素小于等于mid，
            //因为矩阵每一行的数据可以表示为[i*1, i*2, …… i*m ]
            int cnt = 0;
            for (int i = 1;i<=n;i++){
                //以第一行为例，mid=5，如果第一行有5个数，则这5个数都小于等于5， 但如果只有3个数，则只能为3
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
