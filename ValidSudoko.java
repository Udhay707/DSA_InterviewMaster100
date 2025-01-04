
import java.util.HashSet;
import java.util.Set;

public class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        String row = "row";
        String col = "col";
        String square = "square";
        String valueSeparator = "|";
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == '.')
                    continue;

                String rowVal = row + i + valueSeparator + board[i][j];
                if(!set.add(rowVal))
                    return false;
            
                String colVal = col + j + valueSeparator + board[i][j];
                if(!set.add(colVal))
                    return false;
                String squareVal = square + i/3 + "" +j/3 + valueSeparator + board[i][j];
                if(!set.add(squareVal))
                    return false;
                
            }
        }
        return true;     
    }

    public static void main(String[] args) {
        char [][]board = new char[][] {
         {'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};

        ValidSudoko sudokoSolver = new ValidSudoko();
        boolean isValid = sudokoSolver.isValidSudoku(board);
        System.out.println(isValid);
        
    }
}
