package letto.offer.leetcode.dfs;

public class leetcode1219 {
    int maxGold = Integer.MIN_VALUE;

    public int getMaximumGold(int[][] grid) {
        if (grid.length==0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j<col; j++){
                if (grid[i][j]>0){
                    dfs(grid, visited, i, j, 0);
                }
            }
        }
        return maxGold;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int sum) {
        if (i<0 || i>grid.length || j<0 || j>grid[0].length || visited[i][j] || grid[i][j]==0) {
            maxGold = Math.max(maxGold,sum);
            return;
        }
        sum+=grid[i][j];
        visited[i][j] = true;
        dfs(grid,visited, i+1, j, sum);
        dfs(grid,visited, i-1, j, sum);
        dfs(grid,visited, i, j+1, sum);
        dfs(grid,visited, i, j-1, sum);
        visited[i][j]= false;
    }
}
