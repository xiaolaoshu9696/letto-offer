package letto.offer.leetcode.dfs;

public class leetcode695岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i=0; i<row; i++){
            for (int j =0; j<col; j++){
                res = Math.max(dfs(grid, i,j),res);
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i<0||i>grid.length||j<0||j>grid[0].length||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        int num =1;
        return num + dfs(grid,i+1,j) +
                dfs(grid,i-1,j)+
                dfs(grid,i,j+1)+
                dfs(grid, i, j-1);
    }

}
