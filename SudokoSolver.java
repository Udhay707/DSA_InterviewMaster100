import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokoSolver {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> squareMap = new HashMap<>();
        for(int i=0; i<9; i++){
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            squareMap.put(i, new HashSet<>());
        }
        int[] squareTracker = {0, 3,6};
        for(int i=0; i<board.length; i++){
            int startSquare = squareTracker[i/3];
            for(int j=0; j<board.length; j++){
                if(board[i][j] == '.')
                    continue;

                var rowSet = rowMap.get(i);
                if(!rowSet.add(board[i][j]))
                    return false;
            
                var colSet = colMap.get(j);
                if(!colSet.add(board[i][j]))
                    return false;
                
                var squareSet = squareMap.get(startSquare + (j/3));
                if(!squareSet.add(board[i][j]))
                    return false;
                
            }
        }
        return true;     
    }

    public static void main(String[] args) {
        char [][]board = new char[][] {
            {'8','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};

        SudokoSolver sudokoSolver = new SudokoSolver();
        boolean isValid = sudokoSolver.isValidSudoku(board);
        System.out.println(isValid);
        
    }
}
