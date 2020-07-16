package letto.offer.leetcode.dfs;

public class leetcode79 {
    boolean flag = false;

    public static void main(String[] args) {
        leetcode79 s = new leetcode79();
        char[][] board = new char[][]{{'a','b'},{'c','d'}};
        String word = "cdba";
        System.out.println(s.exist(board,word));

    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] visit = new boolean[row][col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(board,visit,i,j,0, word);
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board, boolean[][] visit, int i , int j, int len,String word){
        if(i < 0 || i>=board.length || j<0 ||j>=board[0].length || visit[i][j] || board[i][j] != word.charAt(len) || flag){
            return;
        }
        if(len==word.length()-1){
            if(word.charAt(len) == board[i][j]){
                flag = true;
            }
            return;
        }
        visit[i][j] = true;

        dfs(board, visit, i+1, j, len+1, word);
        dfs(board, visit, i-1, j, len+1, word);
        dfs(board, visit, i, j+1, len+1, word);
        dfs(board, visit, i, j-1, len+1, word);
        visit[i][j] = false;
    }
}
