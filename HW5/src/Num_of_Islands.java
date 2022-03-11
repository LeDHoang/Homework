//Leetcode problems using DFS
public class Num_of_Islands {
    //Typically we are just checking for possibility of an island
    private void dfs(char[][] grid, int i, int j){
        int h = grid.length;
        int w = grid[0].length;
        if(i<0||i>=h||j<0||j>=w||grid[i][j]=='0') return;

        grid[i][j]='0';
        //Checking adjacent Nodes
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

    }



    public int numIslands(char[][] grid) {
        int h = grid.length;
        if(h==0) return 0;
        int w = grid[0].length;

        int total=0;

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(grid[i][j]=='0')
                {
                    continue;
                }
                dfs(grid, i , j);
                total++;
            }

        }

        return total;

    }
}
