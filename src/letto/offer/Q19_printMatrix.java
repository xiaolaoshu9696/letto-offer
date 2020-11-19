package letto.offer;
import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 */

public class Q19_printMatrix {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4,5}};
        ArrayList<Integer> b = printMatrix(a);
        System.out.println(b.toString());

    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        //行
        int row = matrix.length;
        //列
        int col = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 上下左右边界初始化
        int top = 0, bottom = row-1, left = 0, right = col-1;
        int num = 0;
        //num 保证不越界
        while (num<row*col){
            //从左到右
            for (int j = left; j <= right && num<row*col; j++) {
                list.add(matrix[top][j]);
                num++;
            }
            top++;
            //从上到下
            for (int j = top; j <= bottom && num<row*col; j++) {
                list.add(matrix[j][right]);
                num++;
            }
            right--;
            //从左到右
            for (int j = right; j >= left && num<row*col; j--) {
                list.add(matrix[bottom][j]);
                num++;
            }
            bottom--;
            //从下到上
            for (int j = bottom; j >= top && num<row*col; j--) {
                list.add(matrix[j][left]);
                num++;
            }
            left++;

        }
        return list;
    }
}

