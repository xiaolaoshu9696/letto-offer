package letto.offer.leetcode;


import java.util.Scanner;

/**
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 */

public class leetcode394 {
    private static int index = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(Decoder(str,0));
    }

    private static String Decoder(String str, int mul){
        int mul2 = 0;
        StringBuilder temp = new StringBuilder();
        while (index<str.length()){
            if (str.charAt(index)=='['){
                index++;
                temp.append(Decoder(str,mul2));
            }
            else if (str.charAt(index)==']'){
                StringBuilder res = new StringBuilder();
                for (int i=0;i<mul;i++){
                    res.append(temp);
                }
                index++;
                return res.toString();
            }

            else if (Character.isDigit(str.charAt(index))){
                mul2 = mul2 * 10 + str.charAt(index) - '0';
                index++;
            }
            else temp.append(str.charAt(index++));
        }
        return temp.toString();
    }


}

