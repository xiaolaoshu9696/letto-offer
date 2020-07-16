package letto.offer.leetcode.字节常见题.字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode71 {

    public static void main(String[] args) {
        System.out.println(simplifyPath2("/..."));
    }

    public static String simplifyPath(String path) {
        List<String> p = new ArrayList<>();
        int n = path.length();
        int i = 0;
        StringBuilder s = new StringBuilder();
        while(i<n){
            if(path.charAt(i)=='/'){
                if(s.length()==0){
                    i++;
                    continue;
                }
                else {
                    p.add(s.toString());
                    s = new StringBuilder();
                    i++;
                    continue;
                }
            }
            if(path.charAt(i)=='.'){
                if(i+1<n&&path.charAt(i+1)=='.'){
                    if(p.size()>0){
                        p.remove(p.get(p.size()-1));
                        i = i+2;
                        continue;
                    }
                    i++;
                    continue;
                }
                i++;
                continue;
            }
            s.append(path.charAt(i));
            i++;
        }
        if(s.length()!=0){
            p.add(s.toString());
        }
        StringBuilder res = new StringBuilder();
        if(p.size()!=0){
            for(String temp: p){
                res.append('/').append(temp);
            }
        }
        if(p.size()==0){
            res.append('/');
        }
        return res.toString();

    }

    public static String simplifyPath2(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }
}
