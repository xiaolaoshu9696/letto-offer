package letto.offer.leetcode;
import java.util.*;
public class jisuanqi {

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        s = s.replace(" ","");
        char[] ca = s.toCharArray();
        int num = 0;
        char op = '+';
        for(int i = 0; i<ca.length; i++){
            char c = ca[i];
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            if(!Character.isDigit(c) || i==s.length()-1){
                int pre;
                switch(op){
                    case '+' : stack.push(num);
                        break;
                    case '-' : stack.push(-num);
                        break;
                    case '*' : stack.push(stack.pop()*num);
                        break;
                    case '/' : stack.push(stack.pop()/num);
                        break;
                }
                op = c;
                num = 0;
            }
        }
        int res = 0;
        if(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;


    }
}
