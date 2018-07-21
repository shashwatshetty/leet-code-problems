package mediumproblems;

// Referred The Solution
// Time Taken To Solve: 88 mins
class RotateImageSolution {
	/*
		Below approach uses a simple logic, where we reverse the rows of the matrix,
		i.e. last row becomes first row, second last row becomes second row and so on.
		After which we swap the upper triangle elements with the lower triangle elements.

		In case, we were to rotate anti-clockwise, we would reverse the columns of the matrix,
		i.e. last column becomes first column, second last column becomes second column and so on.
		After which we swap the upper triangle elements with the lower triangle elements.
	*/
    public void rotate(int[][] matrix) {
    	if(matrix == null || matrix.length == 0){
    		return;
    	}
        int temp, start = 0, end = matrix.length - 1;
        while(start < end){
        	for(int i = 0; i < matrix.length; i++){
        		temp = matrix[start][i];
        		matrix[start][i] = matrix[end][i];
        		matrix[end][i] = temp;
        	}
        	start++;
        	end--;
        }
        for(int i = 0; i < matrix.length; i++){
        	for(int j = i + 1; j < matrix.length; j++){
        		temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
    }
}

public class RotateImage{
	public static void main(String args[]){
		RotateImageSolution obj = new RotateImageSolution();
		int[][] m = new int[4][4];
		int count = 1;
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m.length; j++){
				m[i][j] = count;
				count++;
			}
		}
		obj.rotate(m);
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m.length; j++){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
}