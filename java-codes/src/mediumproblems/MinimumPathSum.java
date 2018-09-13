package mediumproblems;

// Took 1 attempt
// Time Taken To Solve: 25 mins
class MinimumPathSumSolution {
    public int minPathSum(int[][] grid) {
    	if(grid == null || grid.length == 0){
    		return 0;
    	}
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        int i = m - 1, j = n - 1;
        while(i >=0 || j >=0){
        	if(i >= 0){
        		grid[i][n] += grid[i + 1][n];
        	}
        	if(j >= 0){
        		grid[m][j] += grid[m][j + 1];
        	}
        	i--;
        	j--;
        }
        for(int r = m - 1; r >= 0; r--){
        	for(int c = n - 1; c >= 0; c--){
        		grid[r][c] += (grid[r + 1][c] > grid[r][c + 1] ? grid[r][c + 1] : grid[r + 1][c]);
        	}
        }
        return grid[0][0];
    }
}

public class MinimumPathSum{
	public static void main(String args[]){
		MinimumPathSumSolution obj = new MinimumPathSumSolution();
		int[][] g = {{1, 1, 2}, {0, 1, 1}, {0, 1, 1}};
		System.out.println(obj.minPathSum(g));
	}
}