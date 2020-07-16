package letto.offer.leetcode;

import java.util.Arrays;

public class leetcode1433 {
    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("abc", "xya"));
    }

    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        boolean[] b = new boolean[c1.length];
        for(int i = 0; i<c1.length;i++){
            b[i] = c1[i]<=c2[i];
        }
        boolean flag = false;
        for (int i = 0; i<c1.length;i++){
            if (i==0) flag = b[0];
            else{
                if (flag==b[i]) continue;
                else return false;

            }
        }
        return true;

    }
}
