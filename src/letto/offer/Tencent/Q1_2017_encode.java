package letto.offer.Tencent;

import java.util.Scanner;

public class Q1_2017_encode {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            String str = s.next();
            System.out.println(encode(str));
        }

    }
    public static int encode(String str){
        int len = str.length();
        int index =0;
        for (int i=0; i<len;i++){
            char a = str.charAt(i);
            if (a>='a'&&a<='y') {
                int gap = (int) a - 'a';
                index += (gap * cal(i));
                if (i != 0) ++index;
            }
        }
        return index;

    }
    public static int cal(int i){
        if (i==0) return 25 + 25*25 + 25*25*25 + 1;
        if (i==1) return 25 + 25*25 +1;
        if (i==2) return 25 + 1;
        if (i==3) return 1;
        else return 0;
    }
}
