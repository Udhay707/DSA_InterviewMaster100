public class NoOfIslands {
    public int numIslands(char[][] grid) {
        int totalIsland = 0;
        char countedAsIsland = '2';
        for(int row=0; row<grid.length; row++){
            for(int col=0; col< grid[row].length; col++){
                if(grid[row][col] == '1'){
                    dfs(row, col, grid);
                    totalIsland++;
                }
            }
        }
        return totalIsland;
    }

    private void dfs (int row, int col, char[][] grid){
        grid[row][col] = '2';
        //up
        if(row>0 && grid[row-1][col] == '1')
            dfs(row-1, col, grid);
        //down
        if(row < grid.length-1 && grid[row+1][col]== '1')
            dfs(row+1, col, grid);
        //left
        if( col > 0 && grid[row][col-1] == '1')
            dfs(row, col-1, grid);
        //right
        if(col < grid[row].length-1 && grid[row][col+1] == '1')
            dfs(row, col+1, grid);
        
    }

    public static void main(String[] args) {
        char[][] island =  {
            {'1','0','1','1', '1'},
            {'1','0','1','0', '1'},
            {'1','1','1','0', '1'}
          };

        NoOfIslands noOfIslands = new NoOfIslands();
        int k = noOfIslands.numIslands(island);
        System.out.println(k);
    }
}
