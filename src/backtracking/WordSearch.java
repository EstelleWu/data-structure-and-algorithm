package backtracking;

public class WordSearch {
	/*
    4 directions -> as long as one of its next positions work -> work
    */
    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0){
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        int R = board.length;
        int C = board[0].length;
        boolean[][] visited = new boolean[R][C];
        for (int r = 0; r < R; r++){
            for (int c = 0; c < C; c++){
                if (existHelper(board, word, 0, r, c, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    /* input: board, word, index, r, c, visited
                     next char
       output: boolean
    */
    private static boolean existHelper(char[][] board, String word, int index, int r, int c, boolean[][] visited){
        if (index == word.length()){
            return true;
        }
        if (!isValid(r, c, visited)){
            return false;
        }
        if (board[r][c] != word.charAt(index)){
            return false;
        }
        visited[r][c] = true;
        boolean up = existHelper(board, word, index + 1, r - 1, c, visited);
        boolean down = existHelper(board, word, index + 1, r + 1, c, visited);
        boolean left = existHelper(board, word, index + 1, r, c - 1, visited);
        boolean right = existHelper(board, word, index + 1, r, c + 1, visited);
        if (up || down || left || right){
            return true;
        }else{
            visited[r][c] = false;
            return false;
        } 
    }
    
    private static boolean isValid(int r, int c, boolean[][] visited){
        int R = visited.length;
        int C = visited[0].length;
        if (r < 0 || r >= R){
            return false;
        }
        if (c < 0 || c >= C){
            return false;
        }
        return !visited[r][c];
    }
    
	public static void main(String[] args) {
		char[][] board = {{'a'}};
		String word = "a";
		boolean res = exist(board, word);
		System.out.println(1);

	}

}
