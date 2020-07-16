package letto.offer.leetcode;

public class leetcode289 {
    public static void main(String[] args) {

    }

    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length+2][board[0].length+2];
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                temp[i+1][j+1] = board[i][j];
            }
        }
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                board[i][j] = setboard(i,j,temp);
            }
        }
    }
    public static int setboard(int i, int j,int[][] temp){
        int count = 0;
        //temp中的位置
        for (int x = i; x<i+3; x++){
            for(int y = j; y<j+3;y++){
                if(x==i+1&&y==j+1) continue;
                if (temp[x][y]==1) count++;
            }
        }
        if(count==3) return 1;
        if (temp[i+1][j+1]==1&&count==2) return 1;
        else return 0;



    }

}
