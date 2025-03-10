// Time Complexity : O(m*n 4^L) where m*n is the size of the matrix and L is the length of the search word.
// Space Complexity : O(m*n + L) since i am using the visited array but if we can mark the nodes visited within the matrix then O(L) is the recursive stack space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    private boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][] visited)
    {
        if(index == word.length()-1 && board[row][col] == word.charAt(index))
            return true;
        if(board[row][col] != word.charAt(index))
            return false;

        
        int[][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        visited[row][col] = true;
        boolean result = false;
        for(int i=0; i<dir.length; i++)
        {
            int nrow = row + dir[i][0];
            int ncol = col + dir[i][1];
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && !visited[nrow][ncol])
                if(dfs(board, word, nrow, ncol, index+1, visited))
                {
                    result = true;
                    break;
                }         
        }
        visited[row][col] = false;
        return result;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
               if(dfs(board, word, i, j, 0, visited))
                return true;
            }
        }
        return false;
    }
}