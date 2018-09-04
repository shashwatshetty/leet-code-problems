package mediumproblems;

// Took 1 attempt
// Time Taken To Solve: 26 mins
class UniquePathsSolution {
    public int uniquePaths(int m, int n) {
    	if(m == 0 || n == 0){
    		return 0;
    	}
        int[][] maze = new int[m][n];
        int r = 0, c = 0;
        while(r < m || c < n){
        	if(r < m){
        		maze[r][n - 1] = 1;
        	}
        	if(c < n){
        		maze[m - 1][c] = 1;
        	}
        	r++;
        	c++;
        }
        for(int i = m - 2; i >= 0; i--){
        	for(int j = n - 2; j >= 0; j--){
        		maze[i][j] = maze[i + 1][j] + maze[i][j + 1];
        	}
        }
        return maze[0][0];
    }
}

public class UniquePaths{
	public static void main(String args[]){
		UniquePathsSolution obj = new UniquePathsSolution();
		System.out.println(obj.uniquePaths(7, 3));
		System.out.println(obj.uniquePaths(3, 3));
		System.out.println(obj.uniquePaths(1, 1));
	}
}