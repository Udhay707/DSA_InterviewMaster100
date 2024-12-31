public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int [][]resultMatrix = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        for(int row =0; row<matrix.length; row++){
            for(int col=0; col<matrix[row].length; col++){
                if(matrix[row][col] == '1'){
                    int left = col -1 >= 0 ? resultMatrix[row][col-1] : 0;
                    int up = row-1 >= 0 ? resultMatrix[row-1][col] : 0;
                    int diag = row-1 >= 0 && col-1 >= 0 ? resultMatrix[row-1][col-1]: 0;
                    resultMatrix[row][col] = Math.min(diag, Math.min(left, up)) + 1;
                    maxArea = Math.max(resultMatrix[row][col], maxArea);
                }
            }
        }

        return maxArea*maxArea;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        int maxArea = maximalSquare.maximalSquare(new char[][]{{'1','1'},{'1','1'}});
        System.out.println(maxArea);
    }
}
