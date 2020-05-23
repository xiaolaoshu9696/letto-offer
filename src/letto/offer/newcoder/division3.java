package letto.offer.newcoder;

import java.util.Scanner;

public class division3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int left = s.nextInt();
        int right = s.nextInt();
        System.out.println(cal(right) - cal(left-1));

    }

    public static int cal(int index){
        int y = index%3;
        int x = index/3;
        return x*2+y/2;
    }
}
