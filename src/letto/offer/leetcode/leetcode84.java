package letto.offer.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 问题分析： 我们要找到每个柱子左右小于它的最近柱子，包含这根柱子的最大矩形面积一定是两边界相隔长度乘上这根柱子长度
 * 所以问题转换为求每根柱子的左右边界,通过维护一个单调不减栈实现
 *
 */


public class leetcode84 {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights){
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        //从左往右遍历，找到每根柱子的左边界
        for (int i =0; i<n; i++){
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        int[] right = new int[n];
        stack.clear();
        //从右往左遍历，找到每根柱子的右边界
        for (int i =n-1; i>=0; i--){
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i]-left[i]-1)*heights[i]);
        }
        return ans;


    }

}
