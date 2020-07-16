package letto.offer.leetcode.周赛.zhousai192;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BrowserHistory {
    String homepage;
    //保存back
    Stack<String> Stack1 = new Stack<>();
    //保存前进
    Stack<String> Stack2 = new Stack<>();

    public BrowserHistory(String homepage) {
        this.homepage = homepage;
        Stack1.push(homepage);
    }

    public void visit(String url) {
        Stack1.push(url);
        Stack2.clear();
    }
    // 不把最后的homepage弹出，令step最多等于size-1
    public String back(int steps) {
        int size = Stack1.size();
        if(steps>size-1) steps = size-1;
        for (int i = 0; i<steps; i++) {

            String s = Stack1.pop();
            Stack2.push(s);

        }
        return Stack1.peek();
    }

    public String forward(int steps) {
        for (int i =0; i<steps; i++){
            if (!Stack2.isEmpty()){
                String s = Stack2.pop();
                Stack1.push(s);
            }
            if (Stack2.isEmpty()){
                return Stack1.peek();
            }
        }
        return Stack1.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
