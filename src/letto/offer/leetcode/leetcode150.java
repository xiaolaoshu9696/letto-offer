package letto.offer.leetcode;

import java.util.Stack;

/**
 * @author hkc
 * @date 2020/8/30 10:08
 */
public class leetcode150 {
    public static void main(String[] args) {
        leetcode150 s = new leetcode150();
        String[] str = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(s.evalRPN(str));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<tokens.length; i++){
            if(isdigit(tokens[i])){
                stack.push(Integer.valueOf(tokens[i]));
            }else{
                if(tokens[i].equals("+")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a+b);
                }else if(tokens[i].equals("-")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b-a);
                } else if(tokens[i].equals("*")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a*b);
                } else if(tokens[i].equals("/")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b/a);
                }
            }
        }
        return stack.peek();

    }

    public boolean isdigit(String str){
        char first = str.charAt(0);
        if (str.length()==1 && first=='-') return false;
        if (first != '-' && !Character.isDigit(first)) return false;
        for(int i = 1; i<str.length(); i++){
            if(!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

}
