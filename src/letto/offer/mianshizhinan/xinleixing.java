package letto.offer.mianshizhinan;

import java.util.Scanner;

public class xinleixing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();
        System.out.println(printK(str,k));
    }

    private static String printK(String str, int k){
        char c = str.charAt(k);
        if (c>='a'){
            int count = 0;
            int index = k-1;
            while (str.charAt(index)<='Z'){
                count++;
                index--;
            }
            if (count%2==0) return String.valueOf(c);
            else return str.substring(k-1, k+1);
        }
        else{
            int count = 0;
            int index = k-1;
            while (str.charAt(index)<='Z'){
                count++;
                index--;
            }
            if (count%2==1) return str.substring(k-1, k+1);
            else return str.substring(k, k+2);
        }

    }


}
