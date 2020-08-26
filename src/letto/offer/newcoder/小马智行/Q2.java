package letto.offer.newcoder.小马智行;

import java.util.Scanner;

public class Q2 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int h = s.nextInt();
        int[] height = new int[n];
        int[] res = new int[n];
        for (int i = 0 ;i <n; i++){
            height[i] = s.nextInt();
        }


        for (int i = 0; i<height.length; i++){
            if (i ==0) res[i] = 0;

            else res[i] = find(height,i,h)+1;
        }
        for (int i = 0; i<height.length;i++){
            System.out.println(res[i]);
        }

    }

    private static int find(int[] height, int i,int h) {
        for (int j = i-1; j>=0; j--){
            int gap = height[i]+((i-j)*(h-height[i]))/i;
            if (height[j]>gap){
                return j;
            }
        }
        return 0;
    }

}
