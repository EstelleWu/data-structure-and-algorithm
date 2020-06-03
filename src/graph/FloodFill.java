package graph;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	/*
    number of islands
    */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0){
            return image;
        }
        // step1: make a copy of image
        int R = image.length;
        int C = image[0].length;
        int[][] res = new int[R][C];
        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                res[r][c] = image[r][c];
            }
        }
        if (res[sr][sc] == newColor){
            return res;
        }
        
        // step2: flood fill, dfs / bfs
        int originalColor = res[sr][sc];
        // dfs(res, sr, sc, originalColor, newColor);
        bfs(res, sr, sc, originalColor, newColor);
        return res;
    }
    
    // private void dfs(int[][] matrix, int r, int c, int originalColor, int newColor){
    //     matrix[r][c] = newColor;
    //     int[] d_r = {1, 0, -1, 0};
    //     int[] d_c = {0, 1, 0, -1};
    //     for (int i = 0; i < 4; i++){
    //         int nextR = r + d_r[i];
    //         int nextC = c + d_c[i];
    //         if (isValid(matrix, nextR, nextC, originalColor)){
    //             dfs(matrix, nextR, nextC, originalColor, newColor);
    //         }
    //     }
    // }
    
    private void bfs(int[][] matrix, int r, int c, int originalColor, int newColor){
        matrix[r][c] = newColor;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        int[] d_r = {1, 0, -1, 0};
        int[] d_c = {0, 1, 0, -1};
        while (queue.size() > 0){
            int[] coordinates = queue.poll();
            int curR = coordinates[0];
            int curC = coordinates[1];
            for (int i = 0; i < 4; i++){
                int nextR = curR + d_r[i];
                int nextC = curC + d_c[i];
                if (isValid(matrix, nextR, nextC, originalColor)){
                    matrix[nextR][nextC] = newColor;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }
    
    private boolean isValid(int[][] matrix, int r, int c, int originalColor){
        int R = matrix.length;
        int C = matrix[0].length;
        if (r < 0 || r >= R){
            return false;
        }
        if (c < 0 || c >= C){
            return false;
        }
        return matrix[r][c] == originalColor;
    }

}
