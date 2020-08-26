package letto.offer.duoxiancheng;

import java.util.Scanner;

public class jubuzuixiao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int l=0;
        int r = n-1;

        if(n==1){
            System.out.println(0);
        }
        else{
            if(arr[n-1]<arr[n-2]) System.out.println(n-1);
            else if (arr[0]<arr[1]) System.out.println(0);
            else{
                while (l<=r){
                    int m = (l+r)>>1;
                    if (arr[m]<arr[m-1]&&arr[m]<arr[m+1]){
                        System.out.println(m);
                        break;
                    }
                    //往负梯度方向进行二分查找
                    else if (arr[m]>arr[m-1]) r = m-1;
                    else l = m+1;

                }

            }
        }
    }
}
