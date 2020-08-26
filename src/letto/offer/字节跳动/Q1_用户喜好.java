package letto.offer.字节跳动;

import java.util.Scanner;

public class Q1_用户喜好 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n_people = sc.nextInt();
        int[] fa_list = new int[n_people];
        for(int i = 0; i<n_people; i++){
            fa_list[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            int f = sc.nextInt();
            int nums=0;
            for (int j = left-1; j<right;j++){
                if (fa_list[j]==f) nums++;
            }
            System.out.println(nums);
        }

    }

}
