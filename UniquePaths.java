public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int [][]matrix = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int top = 0, left = 0;
                if(i-1>=0){
                    top = matrix[i-1][j];
                }
                if(j-1>=0){
                    left = matrix[i][j-1];
                }
                matrix[i][j] = Math.max(top + left, 1);
            }
        }
        return matrix[m-1][n-1];
    } 
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int totalWays = uniquePaths.uniquePaths(3, 7);
        System.out.println(totalWays);
    }
}
