package letto.offer.vivo2020chunzhao;

public class Q1 {
    /**
     * 实现方案
     *
     * @param m int整型 最少m个键
     * @param n int整型 最多n个键
     * @return int整型
     */
    public int solution(int m, int n) {
        // write code here
        int count = 0;
        n = n>9?9:n;
        for (int i=m; i<=n; i++){
            boolean[][] flag = new boolean[3][3];
            for (int j=0; j<3; j++){
                for (int t=0; t<3; t++){
                    count += findNext(flag, j, t, 0, i);
                }
            }
        }
        return count;
    }

    public static int findNext(boolean[][] flags, int curRow, int curCol, int steps, int n){
        int count = 0;
        steps++;
        flags[curRow][curCol] = true;
        if (steps==n) return 1;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (flags[i][j]==false && canStep(flags, curRow, curCol, i, j)){
                    count += findNext(flags,i,j,steps,n);
                    flags[i][j] = false;
                }
            }
        }
        flags[curRow][curCol] = false;
        return count;
    }

    private static boolean canStep(boolean[][] flags, int curRow, int curCol, int targetRow, int targetCol){
        if (curRow == targetRow){
            int low = curCol<targetCol ? curCol:targetCol;
            if (Math.abs(curCol-targetCol)>1 && flags[curRow][low+1]==false){
                return false;
            }
        }
//         在同一列
        if(curCol == targetCol) {
            int low = curRow < targetRow?curRow:targetRow;
            if(Math.abs(curRow - targetRow) >1 && flags[low+1][curCol] == false)
                return false;
        }
//         斜对角
        if(Math.abs(curRow-targetRow)==2 && Math.abs(curCol-targetCol)==2 && flags[1][1] == false)
            return false;
        return true;
    }

}
