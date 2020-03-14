package letto.offer.Tencent;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 压缩算法
 *
 */

public class Q1_compression {
    private static int num = 0;


    public static void main(String[] args) {
        String str = "AC[3|B[2|CA]D]FG";
        String temp = Decoder(str,0);
        System.out.println(temp);
        temp = Decoder(str);
        System.out.println(temp);
    }
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
