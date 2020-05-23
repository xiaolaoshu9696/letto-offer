package letto.offer.pingduoduo;

import java.util.Scanner;

public class Q2_2020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        for (int i = 0; i<nums; i++){
            int N = sc.nextInt();
            maxandmin(N);
        }
    }

    public static void maxandmin(int N){
        if (N==1||N==2){
            System.out.println("1 1");
            return;
        }
        //之后每4个一组 0011
        int min = getmin(N);
        int max = N-getmin(N-1);
        System.out.println(min + " " + max);
    }

    public static int getmin(int N){
        int temp = (N-2)%4;
        if (temp==1 || temp==2){
            return 0;
        }
        else return 1;
    }

}
