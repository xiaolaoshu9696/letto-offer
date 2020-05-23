package letto.offer.Tencent;

import com.sun.jdi.IncompatibleThreadStateException;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，
 * 所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 *
 * 输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
 * 1<=n<=100000;
 * 1<=wi<=100000;
 * 输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
 *
 * 输入：
 * 6
 * 5 3 8 3 2 5
 * 输出 3 3 5 4 4 4
 */
//单调栈

public class Q2_building {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] heights = new int[n];
        for (int i = 0; i<n; i++){
            heights[i] = scanner.nextInt();
        }
        int[] result = new int[n];

        //从前往后遍历
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<n; i++){
            result[i] +=1;
            result[i] += stack.size();

            while (!stack.isEmpty() && stack.peek()<=heights[i]){
                stack.pop();
            }
            stack.push(heights[i]);

        }

        //从后往前遍历
        stack.clear();
        for (int i=n-1; i>=0; i--){
            result[i] += stack.size();
            while (!stack.isEmpty() && stack.peek()<=heights[i]){
                stack.pop();
            }
            stack.push(heights[i]);
        }

        // 输出
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                System.out.print(" " + result[i]);
            } else {
                System.out.print(result[i]);
            }
        }
    }
}
