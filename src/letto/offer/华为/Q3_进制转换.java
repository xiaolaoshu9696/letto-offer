package letto.offer.华为;

import java.util.Scanner;

public class Q3_进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String[] s_arr = s.split(" ");
            transferTen(s_arr);
        }

    }

    private static void transferTen(String[] s_arr) {
        int[] arr = new int[s_arr.length];
        int i = 0;
        for (String s : s_arr) {
            int num = transfer(s);
            arr[i++] = num;
        }
        for (int a:arr){
            System.out.println(a);
        }
    }

    private static int transfer(String s) {
        int len = s.length();
        int res = 0;
        int jinzhi = 1;
        for (int i = len - 1; i > 1; i--) {
            char c = s.charAt(i);
            if (c>='0'&&c<='9') res += Integer.parseInt(String.valueOf(c))*jinzhi;
            if (c>='A' && c<='F'){
                int b = c-'A';
                b = b+10;
                res += b*jinzhi;
            }
            jinzhi = jinzhi*16;
        }
        return res;
    }


}
