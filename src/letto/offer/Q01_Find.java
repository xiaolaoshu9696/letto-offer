package letto.offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */

public class Q01_Find {
    private static int[][] array = {
            {1,2,8,9},
            {2,4,9,12},
            {4,7,10,13},
            {6,8,11,15}
    };
    public static void main(String[] args) {
        Q01_Find object = new Q01_Find();
        boolean result = object.Find(10,array);
        System.out.println(result);
    }
    public boolean Find(int target, int[][] array){
        boolean found = false;
        //从右上角开始找
        //行
        int row = 0;
        //列
        int col = array[0].length-1;
        while (row<array.length && col>=0){
            int value = array[row][col];
            if (target>value) row++;
            else if (target<value) col--;
            else{
                found = true;
                break;
            }
        }
        return found;
    }
}
