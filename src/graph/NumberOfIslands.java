package graph;

import java.util.LinkedList;
import java.util.Queue;

// use bfs or dfs to traverse the graph
public class NumberOfIslands {
	public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int res = 0;
        int R = grid.length;
        int C = grid[0].length;
        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                // when encounter a '1', do dfs / bfs 
                // to mark connected land as the same island
                if (grid[r][c] == '1'){
                    res++;
                    // dfs(grid, r, c);
                    bfs(grid, r, c);
                }
            }
        }
        return res;
    }
    
    // private void dfs(char[][] grid, int r, int c){
    //     grid[r][c] = '0';
    //     int[] d_r = {1, 0, -1, 0};
    //     int[] d_c = {0, 1, 0, -1};
    //     for (int i = 0; i < 4; i++){
    //         int nextR = r + d_r[i];
    //         int nextC = c + d_c[i];
    //         if (isValid(grid, nextR, nextC)){
    //             dfs(grid, nextR, nextC);
    //         }
    //     }
    // }
    
    private static void bfs(char[][] grid, int r, int c){
        grid[r][c] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        int[] d_r = {1, 0, -1, 0};
        int[] d_c = {0, 1, 0, -1};
        while (queue.size() > 0){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            for (int i = 0; i < 4; i++){
                int nextR = r + d_r[i];
                int nextC = c + d_c[i];
                if (isValid(grid, nextR, nextC)){
                    queue.add(new int[]{nextR, nextC});
                    grid[nextR][nextC] = '0';
                }
            }
        }
    }
    
    private static boolean isValid(char[][] grid, int r, int c){
        int R = grid.length;
        int C = grid[0].length;
        if (r < 0 || r >= R){
            return false;
        }
        if (c < 0 || c >= C){
            return false;
        }
        return grid[r][c] == '1';
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1','1','1','1','0'},
				         {'1','1','0','1','0'},
				         {'1','1','0','0','0'},
				         {'0','0','0','0','0'}};
		int res = numIslands(grid);
		
		
	}
	
}


