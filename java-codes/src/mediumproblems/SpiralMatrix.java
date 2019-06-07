package mediumproblems;

import java.util.List;
import java.util.ArrayList;

// Referred The Solution
// Time Taken To Solve: 71 mins
class SpiralMatrixSolution {
	/*
		Below approach maintains a visited matrix to keep a track of the numbers that have been
		added to the List. We need to use a hardcoded clockwise direction, which will either increment
		or decrement the row/column based on if it reaches a bound or a seen element.
	 */
    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> spiral = new ArrayList<Integer>();
    	if(matrix == null || matrix.length == 0) {
    		return spiral;
    	}
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int [][] visited = new int[numRows][numCols];
        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};
        int total = numRows * numCols, r = 0, c = 0, dir = 0;
        while(total > 0) {
        	spiral.add(matrix[r][c]);
        	visited[r][c] = 1;
        	int nextR = r + rowDir[dir];
        	int nextC = c + colDir[dir];
        	if(nextR < 0 || nextC < 0 || nextR == numRows || nextC == numCols || visited[nextR][nextC] == 1) {
        		dir = (dir + 1) % 4;
        		r = r + rowDir[dir];
        		c = c + colDir[dir];
        	}else {
        		r = nextR;
        		c = nextC;
        	}
        	total--;
        }
        return spiral;
    }
}

public class SpiralMatrix {
	public static void main(String args[]) {
		SpiralMatrixSolution obj = new SpiralMatrixSolution();
		int[][] test = { {1, 2, 3, 10}, {4, 5, 6, 11}, {7, 8, 9, 12}, {13, 14, 15, 16} };
		List<Integer> ans = obj.spiralOrder(test);
		for(int i : ans) {
			System.out.print(i + " ");
		}
	}
}