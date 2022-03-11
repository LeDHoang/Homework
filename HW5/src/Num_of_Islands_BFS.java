import java.util.LinkedList;
import java.util.Queue;

public class Num_of_Islands_BFS {
    int res = 0;
    public int numIslands(char[][] grid) {
        for(int i=0 ; i< grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j]=='1'){
                    checkNodes(grid , i , j);
                    res++;
                }
            }
        }
        return res;
    }
    private void checkNodes(char[][]grid , int i , int j){



        int[][] directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        grid[i][j]='0';

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int[] dir : directions){
                int row = temp[0]+dir[0];
                int col = temp[1]+dir[1];
                if(row>=0 && col>= 0 && row<grid.length && col<grid[0].length && grid[row][col] == '1' ){
                    queue.offer(new int[] {row,col});
                    grid[row][col] ='0';
                }

            }
        }
    }
}
