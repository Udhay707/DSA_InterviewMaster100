import java.util.Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int [][]neighbourIndex = {{0,1}, {1,0}, {0,-1}, {-1,0}, {-1, -1}, {1,1}, {1,-1},{-1,1}};
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                int count = 0;
                for(int[] neighbour : neighbourIndex){
                    int row = i+ neighbour[0];
                    int col = j+ neighbour[1];
                    if(row>=0 && col>=0 && row < board.length && col < board[i].length){
                        if(board[row][col] == 1 || board[row][col] ==2 )//they are 1 previously
                            count++;
                    }
                }
                if(board[i][j] == 1 && (count <2 || count >3)){
                    board[i][j] = 2;
                }

                if(board[i][j] == 0 && (count == 3)){
                    board[i][j] =3;
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
        
    }

    public static void main(String[] args) {
        int [][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(board);
        for(int i=0; i<board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
