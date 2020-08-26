package letto.offer.pingduoduo;

import java.util.Scanner;

public class Q4_2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        int normal = sc.nextInt();
        int buffer = sc.nextInt();
        int res = 0;
        if (normal*2>=buffer){
            int n = hp/normal;
            if (hp%normal==0) System.out.println(n);
            else System.out.println(n+1);
        }
        else{
            int n = hp/buffer;
            if (hp%buffer==0) System.out.println(n*2);
            else{
                if (hp%buffer<=normal) System.out.println(n*2+1);
                else System.out.println(n*2+2);
            }


        }

    }
}
