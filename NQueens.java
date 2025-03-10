// Time Complexity : O(N!)
// Space Complexity : O(N) for board and stack space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class Solution {
    List<List<String>> result = new ArrayList<>();
    private boolean place(int[][] matrix, int row, int n)
    {
        if(row == n)
        {
            build(matrix, n);
            return true;
        }
        for(int col=0; col<n; col++)
        {
            boolean valid = isValid(matrix, row, col, n);
            if(valid)
            {
                matrix[row][col] = 1;
                place(matrix, row+1, n);
                matrix[row][col]  = 0;
            }
        }
        return false;
    }
    private boolean isValid(int[][] matrix, int i, int j, int n)
    {
        for(int row=i-1, col=j; row>=0; row--)
            if(matrix[row][col] == 1)
                return false;
        
         for(int row=i-1, col= j-1; row>=0 && col>=0; row--, col--)
            if(matrix[row][col] == 1)
                return false;

          for(int row=i-1, col= j+1; row>=0 && col<n; row--, col++)
            if(matrix[row][col] == 1)
                return false;    

        return true;
    }
    private void build(int[][] matrix, int n)
    {
        List<String> res = new ArrayList<String>();
        for(int i=0; i<n; i++)
        {
            StringBuilder str = new StringBuilder();
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j] == 0)
                    str.append(".");
                else
                    str.append("Q");
            }
            res.add(str.toString());
        }
        result.add(res);
    }


    public List<List<String>> solveNQueens(int n) {
        int[][] matrix = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(matrix[i], 0);
        
        place(matrix, 0, n);

        return result;
    }
}
