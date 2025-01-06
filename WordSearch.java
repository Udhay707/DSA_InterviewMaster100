public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch wordSearch = new WordSearch();
        boolean result = wordSearch.exist(board, "ABCB");
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        boolean [][]isVisited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    isVisited[i][j] = true;
                    if(dfs(board, word,1, isVisited, i, j))
                        return true;
                    isVisited[i][j] = false;
                }
            }
        }
        return false;
        
    }
                    
    private boolean dfs(char[][] board, String word, int index, boolean[][] isVisited, int row, int col) {
        if(index == word.length()){
            return true;
        }
        if(col + 1 < board[row].length && !isVisited[row][col+1] && board[row][col+1] == word.charAt(index)){
            isVisited[row][col+1] = true;
            if(dfs(board, word, index+1, isVisited, row, col+1))
                return true;
            isVisited[row][col+1] = false;
        }
        if(col -1  >= 0 && !isVisited[row][col-1] && board[row][col-1] == word.charAt(index)){
            isVisited[row][col-1] = true;
            if(dfs(board, word, index+1, isVisited, row, col-1))
                return true;
            isVisited[row][col-1] = false;
        }
        if(row + 1 < board.length && !isVisited[row+1][col] && board[row+1][col] == word.charAt(index)){
            isVisited[row+1][col] = true;
            if(dfs(board, word, index+1, isVisited, row+1, col))
                return true;
            isVisited[row+1][col] = false;
        }
        if(row - 1 >=0 && !isVisited[row-1][col] && board[row-1][col] == word.charAt(index)){
            isVisited[row-1][col] = true;
            if(dfs(board, word, index+1, isVisited, row-1, col))
                return true;
            isVisited[row-1][col] = false;
        }

        return false;

    }
}
