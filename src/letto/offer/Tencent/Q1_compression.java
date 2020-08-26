package letto.offer.Tencent;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 压缩算法
 *小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，
 * 于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
 * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
 * 例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 * HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF
 */

public class Q1_compression {
    private static int num = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(Decoder(str));
    }

//    public static void main(String[] args) {
//        String str = "AC[3|B[2|CA]D]FG";
//        String temp = Decoder(str,0);
//        System.out.println(temp);
//        temp = Decoder(str);
//        System.out.println(temp);
//    }
    // 栈的解法
    public static String Decoder(String str){
        int mutil =  0; //乘数
        LinkedList<String> stack_res = new LinkedList<String>(); //暂存‘】’之前的结果
        LinkedList<Integer> mutil_stack = new LinkedList<Integer>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i<str.length();i++){
            if (str.charAt(i)=='['){
                stack_res.addLast(temp.toString());
                temp = new StringBuilder();
            }
            else if (str.charAt(i)==']'){
                StringBuilder temp2 = new StringBuilder();
                //取出乘数
                int num = mutil_stack.removeLast();
                for (int j = 0; j<num; j++) temp2.append(temp);
                temp = new StringBuilder(stack_res.removeLast()+temp2);
            }
            else if (str.charAt(i)=='|'){
                mutil_stack.addLast(mutil);
                mutil = 0;
            }
            else if (Character.isDigit(str.charAt(i))){
                mutil = mutil*10+Integer.parseInt(str.charAt(i)+"");
            }
            else temp.append(str.charAt(i));

        }
        System.out.println(temp.toString());
        return temp.toString();
    }

    //递归解法，碰到'['进入下一层，碰到']'返回上一层；

    public static String Decoder(String str, int index){
        int mutil = 0; //先定义乘数
        StringBuilder temp = new StringBuilder();
        while (num<str.length()){
            if (str.charAt(num) == '['){
                temp.append(Decoder(str,++num));
            }
            else if (str.charAt(num)== ']') {
                StringBuilder temp2 = new StringBuilder();
                for (int j = 0; j<mutil; j++) temp2.append(temp);
                num++;
                return temp2.toString();
            }
            else if (Character.isDigit(str.charAt(num))){
                mutil = mutil*10+Integer.parseInt(str.charAt(num)+"");
                num++;
            }
            else if (str.charAt(num)== '|'){num++;}
            else temp.append(str.charAt(num++));

        }
        return temp.toString();
    }

    
}
