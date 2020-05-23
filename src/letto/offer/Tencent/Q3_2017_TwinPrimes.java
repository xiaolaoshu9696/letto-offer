package letto.offer.Tencent;

import javax.swing.plaf.metal.MetalTheme;
import java.util.Scanner;

public class Q3_2017_TwinPrimes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for (int i = 2;i<=n/2;i++){
            if (isss(i)&&isss(n-i)){
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static boolean isss(int n){
        for (int i = 2; i<=Math.sqrt(n);i++){
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }

}
